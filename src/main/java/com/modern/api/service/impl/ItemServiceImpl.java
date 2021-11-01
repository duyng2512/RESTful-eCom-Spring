package com.modern.api.service.impl;

import com.modern.api.entity.ItemEntity;
import com.modern.api.entity.ProductEntity;
import com.modern.api.service.inf.ItemService;
import com.opw.modern.api.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public ItemEntity toEntity(Item m) {

        ProductEntity productEntity = ProductEntity.builder()
                                                   .price(BigDecimal.valueOf(m.getUnitPrice()))
                                                   .count(m.getQuantity())
                                                   .build();
        productEntity.setId(UUID.fromString(m.getId()));
        ItemEntity entity = ItemEntity.builder()
                                        .product(productEntity)
                                        .build();
        entity.setId(UUID.fromString(m.getId()));
        return entity;
    }

    @Override
    public List<ItemEntity> toEntityList(List<Item> items) {
        if (Objects.isNull(items)){
            return Collections.emptyList();
        } else {
            return items.stream().map(this::toEntity).collect(Collectors.toList());
        }
    }

    @Override
    public Item toModel(ItemEntity e) {
        Item item = new Item();
        item.setUnitPrice(e.getPrice().doubleValue());
        item.setQuantity(e.getQuantity().intValue());
        item.setId(e.getId().toString());
        return item;
    }

    @Override
    public List<Item> toModelList(List<ItemEntity> items) {
        if (Objects.isNull(items)){
            return Collections.emptyList();
        } else {
            return items.stream().map(this::toModel).collect(Collectors.toList());
        }
    }
}
