/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.opw.modern.api;

import com.opw.modern.api.model.NewOrder;
import com.opw.modern.api.model.Order;
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
@Api(value = "Order", description = "the Order API")
public interface OrderApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/orders : Creates a new order for the given order request
     * Creates a new order for the given order request.
     *
     * @param newOrder New Order Request object (optional)
     * @return Order added successfully (status code 201)
     *         or If payment is not authorized. (status code 406)
     */
    @ApiOperation(value = "Creates a new order for the given order request", nickname = "addOrder", notes = "Creates a new order for the given order request.", response = Order.class, tags={ "order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Order added successfully", response = Order.class),
        @ApiResponse(code = 406, message = "If payment is not authorized.") })
    @RequestMapping(value = "/api/v1/orders",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Order> addOrder(@ApiParam(value = "New Order Request object"  )  @Valid @RequestBody(required = false) NewOrder newOrder) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"address\" : { \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }, \"shipment\" : { \"carrier\" : \"carrier\", \"estDeliveryDate\" : \"2000-01-23\", \"id\" : \"id\", \"trackingNumber\" : \"trackingNumber\" }, \"payment\" : { \"authorized\" : true, \"id\" : \"id\", \"message\" : \"message\" }, \"id\" : \"id\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"id\" : \"id\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"id\" : \"id\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>aeiou</id> <date>2000-01-23T04:56:07.000Z</date> <total>UNDEFINED_EXAMPLE_VALUE</total> <status>aeiou</status> </Order>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/orders/{id} : Returns the order of given order ID
     * Returns orders of given order ID
     *
     * @param id Order Identifier (required)
     * @return If order exists. (status code 200)
     *         or Order doesn&#39;t exist for given user. (status code 404)
     */
    @ApiOperation(value = "Returns the order of given order ID", nickname = "getByOrderId", notes = "Returns orders of given order ID", response = Order.class, tags={ "order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "If order exists.", response = Order.class),
        @ApiResponse(code = 404, message = "Order doesn't exist for given user.") })
    @RequestMapping(value = "/api/v1/orders/{id}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Order> getByOrderId(@ApiParam(value = "Order Identifier",required=true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"address\" : { \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }, \"shipment\" : { \"carrier\" : \"carrier\", \"estDeliveryDate\" : \"2000-01-23\", \"id\" : \"id\", \"trackingNumber\" : \"trackingNumber\" }, \"payment\" : { \"authorized\" : true, \"id\" : \"id\", \"message\" : \"message\" }, \"id\" : \"id\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"id\" : \"id\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"id\" : \"id\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>aeiou</id> <date>2000-01-23T04:56:07.000Z</date> <total>UNDEFINED_EXAMPLE_VALUE</total> <status>aeiou</status> </Order>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/orders : Returns the orders of given user
     * Returns orders of given user
     *
     * @param customerId Customer Identifier (required)
     * @return If order exists. (status code 200)
     *         or Order doesn&#39;t exist for given user. (status code 404)
     */
    @ApiOperation(value = "Returns the orders of given user", nickname = "getOrdersByCustomerId", notes = "Returns orders of given user", response = Order.class, responseContainer = "List", tags={ "order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "If order exists.", response = Order.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Order doesn't exist for given user.") })
    @RequestMapping(value = "/api/v1/orders",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Order>> getOrdersByCustomerId(@NotNull @ApiParam(value = "Customer Identifier", required = true) @Valid @RequestParam(value = "customerId", required = true) String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"total\" : \"\", \"address\" : { \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }, \"shipment\" : { \"carrier\" : \"carrier\", \"estDeliveryDate\" : \"2000-01-23\", \"id\" : \"id\", \"trackingNumber\" : \"trackingNumber\" }, \"payment\" : { \"authorized\" : true, \"id\" : \"id\", \"message\" : \"message\" }, \"id\" : \"id\", \"items\" : [ { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" }, { \"unitPrice\" : \"\", \"quantity\" : 0, \"id\" : \"id\" } ], \"card\" : { \"expires\" : \"expires\", \"cvv\" : \"cvv\", \"id\" : \"id\", \"userId\" : \"userId\", \"cardNumber\" : \"cardNumber\" }, \"customer\" : { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"userStatus\" : \"userStatus\", \"phone\" : \"phone\", \"id\" : \"id\", \"email\" : \"email\", \"username\" : \"username\" }, \"status\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>aeiou</id> <date>2000-01-23T04:56:07.000Z</date> <total>UNDEFINED_EXAMPLE_VALUE</total> <status>aeiou</status> </Order>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}