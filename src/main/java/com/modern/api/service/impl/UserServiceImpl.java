package com.modern.api.service.impl;

import com.modern.api.entity.AddressEntity;
import com.modern.api.entity.CardEntity;
import com.modern.api.entity.UserEntity;
import com.modern.api.entity.UserTokenEntity;
import com.modern.api.exception.common.CustomerNotFoundException;
import com.modern.api.exception.common.GenericAlreadyExistsException;
import com.modern.api.exception.common.InvalidRefreshTokenException;
import com.modern.api.repository.UserRepository;
import com.modern.api.repository.UserTokenRepository;
import com.modern.api.security.JwtManager;
import com.modern.api.service.inf.UserService;
import com.opw.modern.api.model.RefreshToken;
import com.opw.modern.api.model.SignedInUser;
import com.opw.modern.api.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserTokenRepository userTokenRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtManager tokenManager;

    public UserServiceImpl(UserRepository repository,
                           UserTokenRepository userTokenRepository,
                           PasswordEncoder bCryptPasswordEncoder,
                           JwtManager tokenManager) {
        this.repository = repository;
        this.userTokenRepository = userTokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenManager = tokenManager;
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
        return Optional.of(repository.findById(UUID.fromString(id)).map(UserEntity::getCards).get());
    }

    @Override
    public Optional<UserEntity> getCustomerById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        if (Strings.isBlank(username)){
            throw new CustomerNotFoundException("Username can not be blank");
        }
        Optional<UserEntity> entity = repository.findByUsername(username);
        return entity.orElseThrow(() -> {
            throw new CustomerNotFoundException("User name " + username + " not found");
        });
    }

    @Override
    public Optional<SignedInUser> createUser(User user) {
        Integer count = repository.findUserEntityByUsername(user.getUsername(), user.getEmail());
        if (count > 0) {
            throw new GenericAlreadyExistsException("Use different username and email.");
        }
        UserEntity userEntity = repository.save(toEntity(user));
        return Optional.of(createSignedInUser(userEntity));
    }

    private SignedInUser createSignedInUser(UserEntity userEntity){
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                                                                                    .username(userEntity.getUsername())
                                                                                    .password(userEntity.getPassword())
                                                                                    .authorities(userEntity.getRole())
                                                                                    .build();
        String token = tokenManager.create(userDetails);
        return new SignedInUser().username(userEntity.getUsername())
                                 .accessToken(token)
                                 .refreshToken(createRefreshToken(userEntity))
                                 .userId(userEntity.getId().toString());
    }

    @Override
    @Transactional
    public SignedInUser getSignedInUser(UserEntity userEntity) {
        userTokenRepository.deleteByUserId(userEntity.getId());
        return createSignedInUser(userEntity);
    }

    @Override
    public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
        Optional<UserTokenEntity> token = userTokenRepository.findByRefreshToken(refreshToken.getRefreshToken());
        if (token.isPresent()){
            SignedInUser signedInUser = createSignedInUser(token.get().getUser());
            signedInUser.refreshToken(refreshToken.getRefreshToken());
            return Optional.of(signedInUser);
        } else {
            throw new InvalidRefreshTokenException("Invalid token");
        }
    }

    @Override
    public void removeRefreshToken(RefreshToken refreshToken) {
        userTokenRepository.findByRefreshToken(refreshToken.getRefreshToken())
                           .ifPresentOrElse(userTokenRepository::delete,
                                   () -> { throw new InvalidRefreshTokenException(" Token [" + refreshToken +" ]");
                           });
    }

    private String createRefreshToken(UserEntity user) {
        String token = RandomHolder.randomKey(128);
        userTokenRepository.save(new UserTokenEntity().setRefreshToken(token).setUser(user));
        return token;
    }

    /* Start of Utils */

    private static class RandomHolder {
        static final Random random = new SecureRandom();
        public static String randomKey(int length) {
            return String.format("%"+length+"s", new BigInteger(length*5/*base 32,2^5*/, random)
                    .toString(32)).replace('\u0020', '0');
        }
    }

    private UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userEntity;
    }

    /* End of Utils */

}
