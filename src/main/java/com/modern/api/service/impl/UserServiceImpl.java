package com.modern.api.service.impl;

import com.modern.api.entity.AddressEntity;
import com.modern.api.entity.CardEntity;
import com.modern.api.entity.UserEntity;
import com.modern.api.repository.UserRepository;
import com.modern.api.service.inf.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteCustomerById(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id) {
        return repository.findById(UUID.fromString(id)).map(UserEntity::getAddresses);
    }

    @Override
    public Iterable<UserEntity> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardByCustomerId(String id) {
        boolean cardExist = repository.findById(UUID.fromString(id)).map(UserEntity::getCards).isPresent();
        if (!cardExist){
            return Optional.empty();
        }
        return Optional.of(repository.findById(UUID.fromString(id)).map(UserEntity::getCards).get().get(0));
    }

    @Override
    public Optional<UserEntity> getCustomerById(String id) {
        return repository.findById(UUID.fromString(id));
    }
}
