package com.modern.api.service.inf;

import com.modern.api.entity.AuthorizationEntity;
import com.opw.modern.api.model.PaymentReq;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface PaymentService {
    public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
    public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
