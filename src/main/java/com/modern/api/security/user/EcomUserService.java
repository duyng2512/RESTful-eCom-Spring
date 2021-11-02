package com.modern.api.security.user;

import com.modern.api.entity.UserEntity;
import com.modern.api.exception.common.CustomerNotFoundException;
import com.modern.api.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class EcomUserService implements UserDetailsService {

    private final UserRepository repository;

    public EcomUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optional = repository.findByUsername(username);
        if (optional.isEmpty())
            throw new UsernameNotFoundException(username);
        UserEntity entity = optional.get();
        return User.withUsername(entity.getUsername())
                   .credentialsExpired(false)
                   .authorities(entity.getRole())
                   .password(entity.getPassword())
                   .accountExpired(false)
                   .accountLocked(false)
                   .build();
    }
}
