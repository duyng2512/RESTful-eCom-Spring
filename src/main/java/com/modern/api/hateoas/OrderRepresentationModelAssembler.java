package com.modern.api.hateoas;

import com.modern.api.controller.CartsController;
import com.modern.api.controller.OrderController;
import com.modern.api.entity.CartEntity;
import com.modern.api.entity.OrderEntity;
import com.modern.api.service.inf.ItemService;
import com.opw.modern.api.model.Cart;
import com.opw.modern.api.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Slf4j(topic = "Order Assembler")
public class OrderRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<OrderEntity, Order> {

    private final UserRepresentationModelAssembler userAssembler;
    private final AddressRepresentationModelAssembler addressAssembler;
    private final CardRepresentationModelAssembler cardAssembler;
    private final ShipmentRepresentationModelAssembler shipmentAssembler;
    private final ItemService itemService;

    public OrderRepresentationModelAssembler(UserRepresentationModelAssembler userAssembler,
                                             AddressRepresentationModelAssembler addressAssembler,
                                             CardRepresentationModelAssembler cardAssembler,
                                             ShipmentRepresentationModelAssembler shipmentAssembler,
                                             ItemService itemService) {
        super(OrderController.class, Order.class);
        this.userAssembler = userAssembler;
        this.addressAssembler = addressAssembler;
        this.cardAssembler = cardAssembler;
        this.shipmentAssembler = shipmentAssembler;
        this.itemService = itemService;
    }

    @Override
    public Order toModel(OrderEntity entity) {
        log.debug("Order Entity {}", entity);
        String orderId = entity.getId().toString();
        Order resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);

        resource.id(orderId)
                .customer(userAssembler.toModel(entity.getUserEntity()))
                .card(cardAssembler.toModel(entity.getCardEntity()))
                .address(addressAssembler.toModel(entity.getAddressEntity()))
                .items(itemService.toModelList(entity.getItems()))
                .shipment(shipmentAssembler.toModel(entity.getShipmentEntity()))
                .date(entity.getOrderDate().toInstant().atOffset(ZoneOffset.UTC));
        log.debug("Assembled Model {}", resource);
        resource.add(linkTo(methodOn(OrderController.class)
                            .getByOrderId(orderId))
                            .withSelfRel());
        return resource;
    }

    public List<Order> toListModel(Iterable<OrderEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                            .map(this::toModel)
                            .collect(Collectors.toList());
    }
}
