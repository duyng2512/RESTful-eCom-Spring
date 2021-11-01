package com.modern.api.hateoas;

import com.modern.api.controller.CustomerController;
import com.modern.api.entity.ShipmentEntity;
import com.modern.api.entity.UserEntity;
import com.opw.modern.api.model.Shipment;
import com.opw.modern.api.model.User;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<UserEntity, User> {

    public UserRepresentationModelAssembler() {
        super(CustomerController.class, User.class);
    }

    @Override
    public User toModel(UserEntity entity) {
        String userId = entity.getId().toString();
        User resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(userId);

        resource.add(linkTo(methodOn(CustomerController.class)
                            .getCustomerById(userId))
                            .withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class)
                            .getAllCustomers())
                            .withRel("customers"));
        resource.add(linkTo(methodOn(CustomerController.class)
                            .getAddressesByCustomerId(userId))
                            .withRel("self_addresses"));
        return resource;
    }

    public List<User> toListModel(Iterable<UserEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                            .map(this::toModel)
                            .collect(toList());
    }
}
