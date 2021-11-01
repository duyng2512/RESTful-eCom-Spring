package com.modern.api.service.inf;

import com.modern.api.entity.ItemEntity;
import com.opw.modern.api.model.Item;

import java.util.List;

public interface ItemService {

    ItemEntity toEntity(Item m);

    List<ItemEntity> toEntityList(List<Item> items);

    Item toModel(ItemEntity e);

    List<Item> toModelList(List<ItemEntity> items);
}
