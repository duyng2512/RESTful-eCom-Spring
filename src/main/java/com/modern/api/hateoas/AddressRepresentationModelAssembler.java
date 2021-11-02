package com.modern.api.hateoas;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.modern.api.controller.AddressController;
import com.modern.api.entity.AddressEntity;
import com.opw.modern.api.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
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
public class AddressRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<AddressEntity, Address> {

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     */
    public AddressRepresentationModelAssembler() {
        super(AddressController.class, Address.class);
    }

    @Override
    public Address toModel(AddressEntity entity) {
        /* Initialize Model */
        Address resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());

        resource.add(linkTo(methodOn(AddressController.class)
                .getAddressesById(entity.getId().toString()))
                .withSelfRel());
        return resource;
    }

    /**
     * Coverts the collection of Product entities to list of resources.
     *
     * @param entities
     */
    public List<Address> toListModel(Iterable<AddressEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                            .map(this::toModel)
                            .collect(toList());
    }
}
