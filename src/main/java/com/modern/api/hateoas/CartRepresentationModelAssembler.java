package com.modern.api.hateoas;

import com.modern.api.controller.CartsController;
import com.modern.api.entity.CartEntity;
import com.opw.modern.api.model.Cart;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CartRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<CartEntity, Cart> {

    public CartRepresentationModelAssembler() {
        super(CartsController.class, Cart.class);
    }

    @Override
    public Cart toModel(CartEntity entity) {
        return null;
    }
}
