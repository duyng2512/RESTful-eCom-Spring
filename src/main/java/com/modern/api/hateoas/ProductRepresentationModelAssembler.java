package com.modern.api.hateoas;

import com.modern.api.controller.PaymentController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.beans.BeanUtils;
import com.modern.api.controller.ProductController;
import com.modern.api.entity.ProductEntity;
import com.opw.modern.api.model.Product;
import com.opw.modern.api.model.Tag;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductRepresentationModelAssembler extends
        RepresentationModelAssemblerSupport<ProductEntity, Product> {

    public ProductRepresentationModelAssembler() {
        super(ProductController.class, Product.class);
    }

    @Override
    public Product toModel(ProductEntity entity) {
        String productId = entity.getId().toString();
        Product resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(productId);

        List<Tag> tagList = entity.getTagEntity()
                                  .stream()
                                  .map(tagEntity -> new Tag()
                                                .id(tagEntity.getId().toString())
                                                .name(tagEntity.getName()))
                                  .collect(toList());
        resource.setTag(tagList);

        resource.add(linkTo(methodOn(ProductController.class)
                            .getProduct(productId))
                            .withSelfRel());
        resource.add(linkTo(methodOn(ProductController.class)
                            .queryProducts(null, null, 1, 10))
                            .withRel("products"));
        return resource;
    }

    public List<Product> toListModel(Iterable<ProductEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false)
                            .map(this::toModel)
                            .collect(toList());
    }
}
