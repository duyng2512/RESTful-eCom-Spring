/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.opw.modern.api;

import com.opw.modern.api.model.RefreshToken;
import com.opw.modern.api.model.SignInReq;
import com.opw.modern.api.model.SignedInUser;
import com.opw.modern.api.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "User", description = "the User API")
public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/auth/token/refresh : Provides new JWT based on valid refresh token.
     * Provides new JWT based on valid refresh token.
     *
     * @param refreshToken  (optional)
     * @return For successful operation. (status code 200)
     */
    @ApiOperation(value = "Provides new JWT based on valid refresh token.", nickname = "getAccessToken", notes = "Provides new JWT based on valid refresh token.", response = SignedInUser.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful operation.", response = SignedInUser.class) })
    @RequestMapping(value = "/api/v1/auth/token/refresh",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<SignedInUser> getAccessToken(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) RefreshToken refreshToken) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accessToken\" : \"accessToken\", \"userId\" : \"userId\", \"refreshToken\" : \"refreshToken\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <refreshToken>aeiou</refreshToken> <accessToken>aeiou</accessToken> <username>aeiou</username> <userId>aeiou</userId> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /api/v1/auth/token : Signin the customer (user)
     * Signin the customer (user) that generates the JWT (access token) and refresh token, which can be used for accessing APIs.
     *
     * @param signInReq  (optional)
     * @return For user sign-in. Once successful, user receives the access and refresh token. (status code 200)
     */
    @ApiOperation(value = "Signin the customer (user)", nickname = "signIn", notes = "Signin the customer (user) that generates the JWT (access token) and refresh token, which can be used for accessing APIs.", response = SignedInUser.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For user sign-in. Once successful, user receives the access and refresh token.", response = SignedInUser.class) })
    @RequestMapping(value = "/api/v1/auth/token",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<SignedInUser> signIn(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) SignInReq signInReq) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accessToken\" : \"accessToken\", \"userId\" : \"userId\", \"refreshToken\" : \"refreshToken\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <refreshToken>aeiou</refreshToken> <accessToken>aeiou</accessToken> <username>aeiou</username> <userId>aeiou</userId> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/auth/token : Signouts the customer (user)
     * Signouts the customer (user). It removes the refresh token from DB. Last issued JWT should be removed from client end that if not removed last for given expiration time.
     *
     * @param refreshToken  (optional)
     * @return Accepts the request for logout. (status code 202)
     */
    @ApiOperation(value = "Signouts the customer (user)", nickname = "signOut", notes = "Signouts the customer (user). It removes the refresh token from DB. Last issued JWT should be removed from client end that if not removed last for given expiration time.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepts the request for logout.") })
    @RequestMapping(value = "/api/v1/auth/token",
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> signOut(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) RefreshToken refreshToken) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /api/v1/users : Signup the a new customer (user)
     * Creates a new customer (user), who can login and do the shopping.
     *
     * @param user  (optional)
     * @return For successful user creation. (status code 201)
     */
    @ApiOperation(value = "Signup the a new customer (user)", nickname = "signUp", notes = "Creates a new customer (user), who can login and do the shopping.", response = SignedInUser.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "For successful user creation.", response = SignedInUser.class) })
    @RequestMapping(value = "/api/v1/users",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<SignedInUser> signUp(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) User user) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accessToken\" : \"accessToken\", \"userId\" : \"userId\", \"refreshToken\" : \"refreshToken\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <refreshToken>aeiou</refreshToken> <accessToken>aeiou</accessToken> <username>aeiou</username> <userId>aeiou</userId> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}