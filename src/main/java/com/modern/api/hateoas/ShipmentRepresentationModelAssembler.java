package com.modern.api.hateoas;

import com.modern.api.controller.ShipmentController;
import com.modern.api.entity.ProductEntity;
import com.modern.api.entity.ShipmentEntity;
import com.opw.modern.api.model.Product;
import com.opw.modern.api.model.Shipment;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ShipmentRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<ShipmentEntity, Shipment> {

    public ShipmentRepresentationModelAssembler() {
        super(ShipmentController.class, Shipment.class);
    }

    @Override
    public Shipment toModel(ShipmentEntity entity) {
        String shipmentId = entity.getId().toString();
        Shipment resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(shipmentId);

        resource.add(linkTo(methodOn(ShipmentController.class)
                            .getShipmentByOrderId(shipmentId))
                    .withSelfRel());
        return resource;
    }

    public List<Shipment> toListModel(Iterable<ShipmentEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                            .map(this::toModel)
                            .collect(toList());
    }
}
