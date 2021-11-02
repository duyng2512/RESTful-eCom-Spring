package com.modern.api.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER(Const.ADMIN),
    ADMIN(Const.USER),
    SUPPORT(Const.SUPPORT);

    private final String authority;

    RoleEnum(String role) {
        authority = role;
    }

    static class Const {
        final static String ADMIN = "ROLE_ADMIN";
        final static String USER = "ROLE_USER";
        final static String SUPPORT = "ROLE_SUPPORT";
    }

    @Override
    @JsonValue
    public String getAuthority() {
        return authority;
    }
}
