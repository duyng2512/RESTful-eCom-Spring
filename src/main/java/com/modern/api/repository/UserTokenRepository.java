package com.modern.api.repository;

import com.modern.api.entity.UserTokenEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends PagingAndSortingRepository<UserTokenEntity, UUID> {
    Optional<UserTokenEntity> findByRefreshToken(String refreshToken);
    Optional<UserTokenEntity> deleteByUserId(UUID userId);
}