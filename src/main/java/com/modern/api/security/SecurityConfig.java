package com.modern.api.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modern.api.security.filter.JwtAuthenticationFilter;
import com.modern.api.security.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import static com.modern.api.security.Constants.SIGNUP_URL;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder bCryptPasswordEncoder;
    private ObjectMapper mapper;
    private JwtManager jwtManager;

    public SecurityConfig(PasswordEncoder bCryptPasswordEncoder,
                          ObjectMapper mapper,
                          JwtManager jwtManager) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mapper = mapper;
        this.jwtManager = jwtManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(SIGNUP_URL).permitAll()
            .antMatchers("/**").authenticated()
            .and()
            .csrf().disable()
            .addFilter(new JwtAuthenticationFilter(super.authenticationManager()))
            .addFilter(new LoginFilter(super.authenticationManager(), jwtManager, mapper))
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
