package com.modern.api.service.inf;

import com.modern.api.entity.AddressEntity;
import com.modern.api.entity.CardEntity;
import com.modern.api.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    public void deleteCustomerById(String id);
    public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
    public Iterable<UserEntity> getAllCustomers();
    public Optional<CardEntity> getCardByCustomerId(String id);
    public Optional<UserEntity> getCustomerById(String id);
}
