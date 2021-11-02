package com.modern.api.controller;

import com.modern.api.hateoas.CardRepresentationModelAssembler;
import com.modern.api.service.inf.CardService;
import com.opw.modern.api.CardApi;
import com.opw.modern.api.UserApi;
import com.opw.modern.api.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthController implements UserApi {


    @Override
    public ResponseEntity<SignedInUser> getAccessToken(@Valid RefreshToken refreshToken) {
        return null;
    }

    @Override
    public ResponseEntity<SignedInUser> signIn(@Valid SignInReq signInReq) {
        return null;
    }

    @Override
    public ResponseEntity<Void> signOut(@Valid RefreshToken refreshToken) {
        return null;
    }

    @Override
    public ResponseEntity<SignedInUser> signUp(@Valid User user) {
        SignedInUser inUser = new SignedInUser();
        inUser.setUserId("Duy Ng");
        inUser.setUsername("username");
        inUser.setAccessToken("token");
        inUser.setRefreshToken("ref");
        return new ResponseEntity<>(inUser, HttpStatus.ACCEPTED);
    }
}
