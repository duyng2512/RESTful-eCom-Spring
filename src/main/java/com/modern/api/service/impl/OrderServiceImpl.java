package com.modern.api.service.impl;

import com.modern.api.entity.OrderEntity;
import com.modern.api.exception.common.ResourceNotFoundException;
import com.modern.api.repository.OrderRepository;
import com.modern.api.service.inf.OrderService;
import com.opw.modern.api.model.NewOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j(topic = "OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<OrderEntity> addOrder(@Valid NewOrder newOrder) {
        if (Strings.isEmpty(newOrder.getCustomerId())) {
            throw new ResourceNotFoundException("Invalid customer id.");
        }
        if (Objects.isNull(newOrder.getAddress()) || Strings.isEmpty(newOrder.getAddress().getId())) {
            throw new ResourceNotFoundException("Invalid address id.");
        }
        if (Objects.isNull(newOrder.getCard()) || Strings.isEmpty(newOrder.getCard().getId())) {
            throw new ResourceNotFoundException("Invalid card id.");
        }
        return orderRepository.insert(newOrder);
    }

    @Override
    public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId) {
        Iterable<OrderEntity> orderEntityIterable = orderRepository.findByCustomerId(UUID.fromString(customerId));
        log.debug("getOrdersByCustomerId {}", orderEntityIterable.toString());
        return orderEntityIterable;
    }

    @Override
    public Optional<OrderEntity> getByOrderId(String id) {
        return orderRepository.findById(UUID.fromString(id));
    };
}
