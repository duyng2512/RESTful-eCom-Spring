package com.modern.api.service.impl;

import com.modern.api.entity.ShipmentEntity;
import com.modern.api.repository.ShipmentRepository;
import com.modern.api.service.inf.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j(topic = "ShipmentServiceImpl")
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository repository;

    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid shipment ID.") String id) {
        log.debug("getShipmentByOrderId Order ID :{}", id);
        return repository.findAllById(List.of(UUID.fromString(id)));
    }
}
