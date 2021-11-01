package com.modern.api.service.inf;

import com.modern.api.entity.OrderEntity;
import com.opw.modern.api.model.NewOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface OrderService {
    public Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
    public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
    public Optional<OrderEntity> getByOrderId(String id);
}
