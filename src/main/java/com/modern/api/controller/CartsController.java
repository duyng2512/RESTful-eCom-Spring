package com.modern.api.controller;


import com.modern.api.entity.CartEntity;
import com.modern.api.hateoas.CartRepresentationModelAssembler;
import com.modern.api.service.inf.CartService;
import com.opw.modern.api.CardApi;
import com.opw.modern.api.CartApi;
import com.opw.modern.api.model.AddCardReq;
import com.opw.modern.api.model.Card;
import com.opw.modern.api.model.Cart;
import com.opw.modern.api.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j(topic = "Carts Controller")
public class CartsController implements CartApi {
    private final CartService service;
    private final CartRepresentationModelAssembler assembler;

    public CartsController(CartService service, CartRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item) {
        log.info("Request for customer ID: {}\nItem: {}", customerId, item);
        return ok(service.addCartItemsByCustomerId(customerId, item));
    }

    @Override
    public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId,
                                                                    @Valid Item item) {
        return ok(service.addOrReplaceItemsByCustomerId(customerId, item));
    }

    @Override
    public ResponseEntity<Void> deleteCart(String customerId) {
        service.deleteCart(customerId);
        return accepted().build();
    }

    @Override
    public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId) {
        service.deleteItemFromCart(customerId, itemId);
        return accepted().build();
    }

    @Override
    public ResponseEntity<Cart> getCartByCustomerId(String customerId) {
        return new ResponseEntity<>(assembler.toModel(service.getCartByCustomerId(customerId)),
                                    HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) {
        return new ResponseEntity<>(service.getCartItemsByCustomerId(customerId),
                                    HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> getCartItemsByItemId(String customerId, String itemId) {
        Item item = service.getCartItemsByItemId(customerId, itemId);
        return new ResponseEntity<>(item,
                                    HttpStatus.OK);
    }
}
