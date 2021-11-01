package com.modern.api.controller;

import com.modern.api.hateoas.OrderRepresentationModelAssembler;
import com.modern.api.service.inf.OrderService;
import com.opw.modern.api.OrderApi;
import com.opw.modern.api.model.NewOrder;
import com.opw.modern.api.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class OrderController implements OrderApi {
    private final OrderRepresentationModelAssembler assembler;
    private final OrderService service;

    public OrderController(OrderService service, OrderRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<Order> addOrder(@Valid NewOrder newOrder) {
        return service.addOrder(newOrder).map(assembler::toModel).map(ResponseEntity::ok)
                      .orElse(notFound().build());
    }

    @Override
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@NotNull @Valid String customerId) {
        return ok(assembler.toListModel(service.getOrdersByCustomerId(customerId)));
    }

    @Override
    public ResponseEntity<Order> getByOrderId(String id) {
        return service.getByOrderId(id).map(assembler::toModel).map(ResponseEntity::ok)
                      .orElse(notFound().build());
    }
}
