package com.modern.api.controller;

import com.modern.api.hateoas.AddressRepresentationModelAssembler;
import com.modern.api.service.inf.AddressService;
import com.opw.modern.api.AddressApi;
import com.opw.modern.api.model.AddAddressReq;
import com.opw.modern.api.model.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import static org.springframework.http.ResponseEntity.accepted;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class AddressController implements AddressApi {

    private final AddressService addressService;
    private final AddressRepresentationModelAssembler modelAssembler;

    public AddressController(AddressService addressService,
                             AddressRepresentationModelAssembler modelAssembler) {
        this.addressService = addressService;
        this.modelAssembler = modelAssembler;
    }

    @Override
    public ResponseEntity<Address> createAddress(@Valid AddAddressReq addAddressReq) {
        return new ResponseEntity<>(addressService.createAddress(addAddressReq)
                                                  .map(modelAssembler::toModel)
                                                  .orElse(null),
                                    HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteAddressesById(String id) {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Address> getAddressesById(String id) {
        return new ResponseEntity<>(addressService.getAddressById(id)
                                                  .map(modelAssembler::toModel)
                                                  .orElse(null),
                                    HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Address>> getAllAddresses() {
        return new ResponseEntity<>(modelAssembler.toListModel(addressService
                                                .getAllAddress()),
                                    HttpStatus.OK);
    }
}
