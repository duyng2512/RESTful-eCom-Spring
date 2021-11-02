package com.modern.api.repository;

import com.modern.api.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {
    @Query(value = "select count(u.*) from UserEntity u where u.username = :username or u.email = :email",
            nativeQuery = true)
    Integer findUserEntityByUsername(String username, String email);

    Optional<UserEntity> findByUsername(String username);
}
