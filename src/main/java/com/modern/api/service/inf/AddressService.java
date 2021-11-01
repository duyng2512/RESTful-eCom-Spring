package com.modern.api.service.inf;

import com.modern.api.entity.AddressEntity;
import com.opw.modern.api.model.AddAddressReq;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {
    public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);

    public void deleteAddressById(String uuid);

    public Optional<AddressEntity> getAddressById(String id);

    public Iterable<AddressEntity> getAllAddress();
}
