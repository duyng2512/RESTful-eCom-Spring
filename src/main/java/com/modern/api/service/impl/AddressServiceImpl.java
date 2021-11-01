package com.modern.api.service.impl;

import com.modern.api.entity.AddressEntity;
import com.modern.api.repository.AddressRepository;
import com.opw.modern.api.model.AddAddressReq;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements com.modern.api.service.inf.AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq) {
        return Optional.of(addressRepository.save(toEntity(addAddressReq)));
    }

    @Override
    public void deleteAddressById(String uuid) {
        addressRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public Optional<AddressEntity> getAddressById(String id) {
        return addressRepository.findById(UUID.fromString(id));
    }

    @Override
    public Iterable<AddressEntity> getAllAddress() {
        return addressRepository.findAll();
    }


    private AddressEntity toEntity(AddAddressReq request){
        return AddressEntity.builder()
                            .city(request.getCity())
                            .country(request.getCountry())
                            .number(request.getNumber())
                            .state(request.getState())
                            .street(request.getStreet())
                            .pinCode(request.getPincode())
                            .residency(request.getResidency())
                            .build();

    }

}
