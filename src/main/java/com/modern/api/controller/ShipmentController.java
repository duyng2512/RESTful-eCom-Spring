package com.modern.api.controller;

import com.modern.api.hateoas.ShipmentRepresentationModelAssembler;
import com.modern.api.service.inf.ShipmentService;
import com.opw.modern.api.ShipmentApi;
import com.opw.modern.api.model.Shipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
public class ShipmentController implements ShipmentApi {

    private final ShipmentService service;
    private final ShipmentRepresentationModelAssembler assembler;

    public ShipmentController(ShipmentService service,
                              ShipmentRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<List<Shipment>> getShipmentByOrderId(String id) {
        log.debug("getShipmentByOrderId Order ID {}", id);
        return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
    }

}
