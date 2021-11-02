package com.modern.api.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.modern.api.security.Constants.ROLE_CLAIM;
import static com.modern.api.security.Constants.SECRET_KEY;
import static java.util.stream.Collectors.toList;

@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        log.debug("Do Filter Jwt Authentication");
        String header = request.getHeader("Authorization");
        if (Objects.isNull(header) || !header.startsWith("Bearer ")){
            log.debug("Authorization Header do not found or don't start with format 'Bearer ' ");
            chain.doFilter(request, response);
            return;
        }
        log.debug("Authorization header found: {}", header);
        Optional<UsernamePasswordAuthenticationToken> authentication = getAuthentication(request);
        authentication.ifPresentOrElse(SecurityContextHolder.getContext()::setAuthentication,
                                        SecurityContextHolder::clearContext);
        chain.doFilter(request, response);
    }

    /* Utils function for validate JWT */
    private Optional<UsernamePasswordAuthenticationToken> getAuthentication(HttpServletRequest request) {
        String JwtToken = request.getHeader("Authorization").replace("Bearer ", "");
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                                                            .build()
                                                            .verify(JwtToken);

        log.debug("Decode JWT Found {}", decodedJWT.toString());
        String user = decodedJWT.getSubject();
        log.debug("User from JWT Found {}", user);
        List<String> authoritiesList = decodedJWT.getClaim(ROLE_CLAIM).asList(String.class);
        UsernamePasswordAuthenticationToken token = null;
        if (!Objects.isNull(authoritiesList)){
            for (String authority : authoritiesList){
                log.debug("Authorities found {}", authority);
            }
            List<GrantedAuthority> authorities = authoritiesList.stream()
                                                        .map(SimpleGrantedAuthority::new)
                                                        .collect(toList());
            token = new UsernamePasswordAuthenticationToken(user,
                                                        null,
                                                        authorities);
        } else {
            token = new UsernamePasswordAuthenticationToken(user,
                                                        null,
                                                        Collections.emptyList());
        }

        return Optional.of(token);
    }

}
