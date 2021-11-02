package com.modern.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import static com.modern.api.security.Constants.ROLE_CLAIM;
import static java.util.stream.Collectors.toList;

@Component
public class JwtManager {

    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;

    public JwtManager(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String create(UserDetails userDetails){
        final long now = System.currentTimeMillis();
        final Date date = new Date(now);
        final List<?> authorities = userDetails.getAuthorities()
                                                              .stream()
                                                              .map(GrantedAuthority::getAuthority)
                                                              .collect(toList());
        final Date expireDate = new Date(now + Constants.EXPIRATION_TIME);

        return JWT.create()
                    .withIssuedAt(date)
                    .withSubject(userDetails.getUsername())
                    .withIssuer("MODERN_API")
                    .withClaim(ROLE_CLAIM, authorities)
                    .withExpiresAt(expireDate)
                    .sign(Algorithm.RSA256(publicKey, privateKey));

    }
}
