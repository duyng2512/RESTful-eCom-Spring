package com.modern.api.hateoas;

import com.modern.api.controller.PaymentController;
import com.modern.api.entity.PaymentEntity;
import com.opw.modern.api.model.Payment;
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
public class PaymentRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<PaymentEntity, Payment> {

    public PaymentRepresentationModelAssembler() {
        super(PaymentController.class, Payment.class);
    }

    @Override
    public Payment toModel(PaymentEntity entity) {
        String paymentId = entity.getId().toString();
        Payment resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(paymentId);

        resource.add(linkTo(methodOn(PaymentController.class)
                    .getOrdersPaymentAuthorization(paymentId))
                    .withSelfRel());
        return resource;
    }

    public List<Payment> toListModel(Iterable<PaymentEntity> paymentEntities){
        if (Objects.isNull(paymentEntities)){
            return Collections.emptyList();
        } else {
            return StreamSupport.stream(paymentEntities.spliterator(), false)
                                .map(this::toModel)
                                .collect(Collectors.toList());
        }
    }
}
