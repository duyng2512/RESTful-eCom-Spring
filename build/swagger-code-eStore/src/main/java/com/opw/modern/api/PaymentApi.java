/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.opw.modern.api;

import com.opw.modern.api.model.Authorization;
import com.opw.modern.api.model.PaymentReq;
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
@Api(value = "Payment", description = "the Payment API")
public interface PaymentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/payments : Authorize a payment request
     * Authorize a payment request.
     *
     * @param paymentReq  (optional)
     * @return For successful fetch. (status code 200)
     */
    @ApiOperation(value = "Authorize a payment request", nickname = "authorize", notes = "Authorize a payment request.", response = Authorization.class, tags={ "payment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful fetch.", response = Authorization.class) })
    @RequestMapping(value = "/api/v1/payments",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Authorization> authorize(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) PaymentReq paymentReq) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"orderId\" : \"orderId\", \"authorized\" : true, \"time\" : \"2000-01-23T04:56:07.000+00:00\", \"message\" : \"message\", \"error\" : \"error\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Authorization> <orderId>aeiou</orderId> <time>2000-01-23T04:56:07.000Z</time> <authorized>true</authorized> <message>aeiou</message> <error>aeiou</error> </Authorization>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/payments : Returns the payment authorization
     * Return the payment authorization for the specified order
     *
     * @param orderId Order Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @ApiOperation(value = "Returns the payment authorization", nickname = "getOrdersPaymentAuthorization", notes = "Return the payment authorization for the specified order", response = Authorization.class, tags={ "payment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful fetch.", response = Authorization.class) })
    @RequestMapping(value = "/api/v1/payments",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Authorization> getOrdersPaymentAuthorization(@NotNull @ApiParam(value = "Order Identifier", required = true) @Valid @RequestParam(value = "orderId", required = true) String orderId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"orderId\" : \"orderId\", \"authorized\" : true, \"time\" : \"2000-01-23T04:56:07.000+00:00\", \"message\" : \"message\", \"error\" : \"error\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Authorization> <orderId>aeiou</orderId> <time>2000-01-23T04:56:07.000Z</time> <authorized>true</authorized> <message>aeiou</message> <error>aeiou</error> </Authorization>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}