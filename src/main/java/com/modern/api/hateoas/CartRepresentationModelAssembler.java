package com.modern.api.hateoas;

import com.modern.api.controller.CartsController;
import com.modern.api.entity.CardEntity;
import com.modern.api.entity.CartEntity;
import com.modern.api.service.inf.ItemService;
import com.opw.modern.api.model.Card;
import com.opw.modern.api.model.Cart;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CartRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<CartEntity, Cart> {

    private final ItemService itemService;

    public CartRepresentationModelAssembler(ItemService itemService) {
        super(CartsController.class, Cart.class);
        this.itemService = itemService;
    }

    @Override
    public Cart toModel(CartEntity entity) {
        String cartId = entity.getId().toString();
        String customerId = entity.getUser().getId().toString();
        Cart resource = new Cart();
        BeanUtils.copyProperties(entity, resource);
        resource.id(cartId)
                .customerId(customerId)
                .items(itemService.toModelList(entity.getItems()));

        resource.add(linkTo(methodOn(CartsController.class)
                            .getCartByCustomerId(customerId))
                            .withSelfRel());
        resource.add(linkTo(methodOn(CartsController.class)
                            .getCartItemsByCustomerId(customerId))
                            .withRel("cart-items"));
        return null;
    }

    public List<Cart> toListModel(Iterable<CartEntity> cartEntities){
        if (Objects.isNull(cartEntities)){
            return Collections.emptyList();
        } else {
            return StreamSupport.stream(cartEntities.spliterator(), false)
                                .map(this::toModel)
                                .collect(Collectors.toList());
        }
    }
}
