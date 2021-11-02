package com.modern.api.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modern.api.security.JwtManager;
import com.opw.modern.api.model.SignInReq;
import com.opw.modern.api.model.SignedInUser;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.server.MethodNotAllowedException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static com.modern.api.security.Constants.TOKEN_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ObjectMapper objectMapper;

    public LoginFilter(AuthenticationManager authenticationManager,
                       JwtManager tokenManager,
                       ObjectMapper mapper) {
        this.authenticationManager = authenticationManager;
        this.jwtManager = tokenManager;
        this.objectMapper = mapper;
        super.setFilterProcessesUrl(TOKEN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
                                                throws AuthenticationException {
        if (!request.getMethod().equals(HttpMethod.POST.toString()))
            throw new MethodNotAllowedException(request.getMethod(),
                                                List.of(HttpMethod.POST));

        try (InputStream inputStream = request.getInputStream()) {
            SignInReq signInReq = new ObjectMapper().readValue(inputStream, SignInReq.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInReq.getUsername(),
                            signInReq.getPassword(),
                            Collections.emptyList()));

        } catch (IOException exception) {
            throw new AuthenticationServiceException("Can not create request");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        User principal = (User) authResult.getPrincipal();
        String token = jwtManager.create(principal);
        SignedInUser user = new SignedInUser().username(principal.getUsername()).accessToken(token);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(objectMapper.writeValueAsString(user));
        response.getWriter().flush();
    }
}
