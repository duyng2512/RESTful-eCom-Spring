package com.modern.api.service.inf;

import com.modern.api.entity.ShipmentEntity;

import javax.validation.constraints.Min;

public interface ShipmentService {
    public Iterable<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
