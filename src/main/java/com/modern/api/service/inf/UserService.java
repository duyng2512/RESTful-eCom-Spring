package com.modern.api.service.inf;

import com.modern.api.entity.AddressEntity;
import com.modern.api.entity.CardEntity;
import com.modern.api.entity.UserEntity;
import com.opw.modern.api.model.RefreshToken;
import com.opw.modern.api.model.SignedInUser;
import com.opw.modern.api.model.User;

import java.util.Optional;

public interface UserService {
    void deleteCustomerById(String id);
    Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
    Iterable<UserEntity> getAllCustomers();
    Optional<CardEntity> getCardByCustomerId(String id);
    Optional<UserEntity> getCustomerById(String id);
    Optional<SignedInUser> createUser(User user);
    UserEntity findUserByUsername(String username);
    SignedInUser getSignedInUser(UserEntity userEntity);
    Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);
    void removeRefreshToken(RefreshToken refreshToken);
}
