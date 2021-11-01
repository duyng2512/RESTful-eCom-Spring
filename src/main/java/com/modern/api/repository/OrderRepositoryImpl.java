package com.modern.api.repository;

import com.modern.api.entity.CartEntity;
import com.modern.api.entity.ItemEntity;
import com.modern.api.entity.OrderEntity;
import com.modern.api.entity.OrderItemEntity;
import com.modern.api.entity.base.BaseEntity;
import com.modern.api.exception.common.ResourceNotFoundException;
import com.modern.api.service.inf.ItemService;
import com.opw.modern.api.model.NewOrder;
import org.springframework.stereotype.Repository;
import com.opw.modern.api.model.Order.StatusEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Repository
@Transactional // When RunTime Exception or Uncheck Exception Rollback is executed
public class OrderRepositoryImpl implements OrderRepositoryExt{

    @PersistenceContext
    EntityManager entityManager;

    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;
    private final CartRepository cartRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemService itemService;

    /* String SQL */
    private final String createOrder = "INSERT INTO ecomm.orders (address_id, card_id, customer_id, order_date, total, status) VALUES(?, ?, ?, ?, ?, ?)";
    private final String getOrder = "SELECT o.* FROM ecomm.orders o WHERE o.customer_id = ? AND o.order_date >= ?";

    /* Exception Message */
    private final String itemNotFoundInCart = "There is no item found in customer's (ID: %s) cart.";
    private final String cartNotFound = "Cart (ID: %s) not found";

    public OrderRepositoryImpl(EntityManager entityManager, ItemRepository itemRepository, AddressRepository addressRepository,
                               CartRepository cartRepository, OrderItemRepository orderItemRepository, ItemService itemService) {
        this.entityManager = entityManager;
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemService = itemService;
    }

    @Override
    public Optional<OrderEntity> insert(NewOrder m) {
        Iterable<ItemEntity> dbItems = itemRepository.findByCustomerId(m.getCustomerId());
        List<ItemEntity> items = StreamSupport.stream(dbItems.spliterator(), false).collect(toList());

        if (items.size() < 1) {
            throw new ResourceNotFoundException(String.format(itemNotFoundInCart, m.getCustomerId()));
        }

        BigDecimal total = BigDecimal.ZERO;
        for(ItemEntity itemEntity: items){
            total = itemEntity.getPrice().multiply(itemEntity.getQuantity()).add(total);
        }

        Timestamp now = Timestamp.from(Instant.now());
        entityManager.createNativeQuery(createOrder)
                    .setParameter(1, m.getAddress().getId())
                    .setParameter(2, m.getCard().getId())
                    .setParameter(3, m.getCustomerId())
                    .setParameter(4, now)
                    .setParameter(5, total)
                    .setParameter(6, StatusEnum.CREATED.getValue())
                    .executeUpdate();

        /* Clear Cart when order created */
        Optional<CartEntity> optionalCartEntity = cartRepository.findByCustomerId(UUID.fromString(m.getCustomerId()));
        CartEntity cartEntity = optionalCartEntity.orElseThrow(() -> new ResourceNotFoundException(String.format(cartNotFound, m.getCustomerId())));
        List<UUID> itemIdsBeClear = cartEntity.getItems().stream().map(BaseEntity::getId).collect(toList());
        itemRepository.deleteCartItemJoinById(itemIdsBeClear, UUID.fromString(m.getCustomerId()));

        OrderEntity entity = (OrderEntity) entityManager.createNativeQuery(getOrder, OrderEntity.class)
                                             .setParameter(1, m.getCustomerId())
                                             .setParameter(2, now)
                                             .getSingleResult();

        List<OrderItemEntity> orderItemEntityList = entity.getItems()
                                                          .stream()
                                                          .map(eachItem -> OrderItemEntity.builder()
                                                                                          .itemID(eachItem.getId())
                                                                                          .orderID(entity.getId())
                                                                                          .build())
                                                          .collect(toList());
        orderItemRepository.saveAll(orderItemEntityList);
        return Optional.of(entity);
    }
}
