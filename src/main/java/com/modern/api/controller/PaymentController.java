package com.modern.api.controller;

import com.modern.api.hateoas.PaymentRepresentationModelAssembler;
import com.modern.api.service.inf.PaymentService;
import com.opw.modern.api.PaymentApi;
import com.opw.modern.api.model.Authorization;
import com.opw.modern.api.model.PaymentReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class PaymentController implements PaymentApi {
    private final PaymentService service;
    private final PaymentRepresentationModelAssembler assembler;

    public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<Authorization> authorize(@Valid PaymentReq paymentReq) {
        return null;
    }

    @Override
    public ResponseEntity<Authorization> getOrdersPaymentAuthorization(
            @NotNull @Valid String id) {
        return null;
    }
}
