package com.modern.api.hateoas;

import com.modern.api.controller.CardController;
import com.modern.api.entity.CardEntity;
import com.opw.modern.api.model.Card;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CardRepresentationModelAssembler extends RepresentationModelAssemblerSupport<CardEntity, Card> {

    public CardRepresentationModelAssembler() {
        super(CardController.class, Card.class);
    }

    @Override
    public Card toModel(CardEntity entity) {
        String userId = Objects.nonNull(entity.getUser()) ? entity.getUser().getId().toString() : null;
        String entityId = entity.getId().toString();

        Card resource = instantiateModel(entity);
        BeanUtils.copyProperties(entity, resource);

        resource.setId(entityId);
        resource.setCardNumber(entity.getNumber());
        resource.setCvv(entity.getCvv());
        resource.setExpires(entity.getExpires());
        resource.setUserId(userId);

        resource.add(linkTo(methodOn(CardController.class).getCardById(entityId))
                    .withSelfRel());

        return resource;
    }

    public List<Card> toListModel(Iterable<CardEntity> cardEntities){
        if (Objects.isNull(cardEntities)){
            return Collections.emptyList();
        } else {
            return StreamSupport.stream(cardEntities.spliterator(), false)
                                .map(this::toModel)
                                .collect(Collectors.toList());
        }
    }
}
