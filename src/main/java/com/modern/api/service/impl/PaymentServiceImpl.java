package com.modern.api.service.impl;

import com.modern.api.entity.AuthorizationEntity;
import com.modern.api.entity.OrderEntity;
import com.modern.api.entity.PaymentEntity;
import com.modern.api.repository.OrderRepository;
import com.modern.api.repository.PaymentRepository;
import com.modern.api.service.inf.PaymentService;
import com.opw.modern.api.model.PaymentReq;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq) {
        return Optional.empty();
    }

    @Override
    public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId) {
        return orderRepository.findById(UUID.fromString(orderId)).map(OrderEntity::getAuthorizationEntity);
    }

}
