package com.modern.api.service.impl;

import com.modern.api.entity.CartEntity;
import com.modern.api.entity.ItemEntity;
import com.modern.api.entity.UserEntity;
import com.modern.api.exception.common.CustomerNotFoundException;
import com.modern.api.exception.common.GenericAlreadyExistsException;
import com.modern.api.exception.common.ItemNotFoundException;
import com.modern.api.repository.CartRepository;
import com.modern.api.repository.UserRepository;
import com.modern.api.service.inf.CartService;
import com.modern.api.service.inf.ItemService;
import com.opw.modern.api.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


import static org.springframework.objenesis.instantiator.util.UnsafeUtils.getUnsafe;

@Service
@Slf4j(topic = "CartServiceImpl")
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemService itemService;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.itemService = itemService;
    }

    @Override
    public List<Item> addCartItemsByCustomerId(String customerId, @Valid Item item) {
        CartEntity entity = getCartByCustomerId(customerId);
        List<ItemEntity> items = Objects.nonNull(entity.getItems()) ? entity.getItems() : Collections.emptyList();
        long count = items.stream().filter(eachItem -> !eachItem.getId().equals(UUID.fromString(item.getId()))).count();
        if (count > 0L){
            getUnsafe().throwException(new GenericAlreadyExistsException(
                    String.format("Item with Id (%s) already exists. You can update it.", item.getId())));
        } else {
            entity.getItems().add(itemService.toEntity(item));
        }
        return itemService.toModelList(cartRepository.save(entity).getItems());
    }

    @Override
    public List<Item> addOrReplaceItemsByCustomerId(String customerId, @Valid Item item) {
        CartEntity entity = getCartByCustomerId(customerId);
        List<ItemEntity> items = Objects.nonNull(entity.getItems()) ? entity.getItems() : Collections.emptyList();
        AtomicBoolean isExist = new AtomicBoolean(false);
        items.forEach(eachItem -> {
            if (eachItem.getProduct()
                        .getId()
                        .equals(UUID.fromString(item.getId()))) {
                eachItem.setPrice(BigDecimal.valueOf(item.getUnitPrice()));
                eachItem.setQuantity(BigDecimal.valueOf(item.getQuantity()));
                isExist.set(true);
            }
        });
        if (!isExist.get()) {
            entity.getItems().add(itemService.toEntity(item));
        }
        return itemService.toModelList(cartRepository.save(entity).getItems());
    }

    @Override
    public void deleteCart(String customerId) {
        CartEntity entity = getCartByCustomerId(customerId);
        cartRepository.deleteById(entity.getId());
    }

    @Override
    public void deleteItemFromCart(String customerId, String itemId) {
        CartEntity cartEntity = cartRepository.findByCustomerId(UUID.fromString(customerId))
                                            .orElseThrow(() -> new CustomerNotFoundException(customerId));
        List<ItemEntity> updateItems = cartEntity.getItems()
                                                .stream()
                                                .filter(item -> !item.getId().equals(UUID.fromString(itemId)))
                                                .collect(Collectors.toList());
        cartEntity.setItems(updateItems);
        cartRepository.save(cartEntity);
    }

    @Override
    public CartEntity getCartByCustomerId(String customerId) {
        log.debug("START getCartByCustomerId {}", customerId);
        CartEntity cartEntity = cartRepository.findByCustomerId(UUID.fromString(customerId))
                                              .orElse(new CartEntity());

        log.debug("getCartByCustomerId Entity {}", cartEntity.toString());
        if (Objects.isNull(cartEntity.getUser())){
            Optional<UserEntity> userEntity = userRepository.findById(UUID.fromString(customerId));

            if (userEntity.isPresent()){
                cartEntity.setUser(userEntity.get());
            } else {
                throw new CustomerNotFoundException(String.format("Customer ID %s", customerId));
            }
        }
        return cartEntity;
    }

    @Override
    public List<Item> getCartItemsByCustomerId(String customerId) {
        CartEntity cartEntity = getCartByCustomerId(customerId);
        return itemService.toModelList(cartEntity.getItems());
    }

    @Override
    public Item getCartItemsByItemId(String customerId, String itemId) {
        log.debug("START getCartItemsByItemId Customer ID {} | Item id {}", customerId, itemId);
        CartEntity cartEntity = getCartByCustomerId(customerId);
        log.debug("getCartItemsByItemId Entity {}", cartEntity.toString());
        AtomicReference<ItemEntity> itemEntity = new AtomicReference<>();
        cartEntity.getItems().forEach(item -> {
            if (item.getProduct().getId().equals(UUID.fromString(itemId))) itemEntity.set(item);
        });
        log.debug("getCartItemsByItemId itemEntity {}", itemEntity.toString());
        if (Objects.isNull(itemEntity.get()))
            getUnsafe().throwException(new ItemNotFoundException(String.format(" - %s", itemId)));
        return itemService.toModel(itemEntity.get());
    }
}
