package com.modern.api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.modern.api.security.filter.JwtAuthenticationFilter;
import com.modern.api.security.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.util.HashMap;
import java.util.Map;

import static com.modern.api.security.Constants.SIGNUP_URL;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder bCryptPasswordEncoder;
    private final ObjectMapper mapper;
    private final JwtManager jwtManager;
    private final UserDetailsService service;


    public SecurityConfig(PasswordEncoder bCryptPasswordEncoder,
                          ObjectMapper mapper,
                          JwtManager jwtManager,
                          UserDetailsService service) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mapper = mapper;
        this.jwtManager = jwtManager;
        this.service = service;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(SIGNUP_URL).permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*http.authorizeRequests()
            .antMatchers(SIGNUP_URL).permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .addFilter(new JwtAuthenticationFilter(super.authenticationManager()))
            .addFilter(new LoginFilter(super.authenticationManager(), jwtManager, mapper))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    }

}
