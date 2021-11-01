/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.opw.modern.api;

import com.opw.modern.api.model.Cart;
import com.opw.modern.api.model.Item;
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
@Api(value = "Cart", description = "the Cart API")
public interface CartApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/carts/{customerId}/items : Adds an item in shopping cart
     * Adds an item to the shopping cart if it doesn&#39;t already exist, or increment quantity by the specified number of items if it does.
     *
     * @param customerId Customer Identifier (required)
     * @param item Item object (optional)
     * @return Item added successfully (status code 201)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Adds an item in shopping cart", nickname = "addCartItemsByCustomerId", notes = "Adds an item to the shopping cart if it doesn't already exist, or increment quantity by the specified number of items if it does.", response = Item.class, responseContainer = "List", tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Item added successfully", response = Item.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<List<Item>> addCartItemsByCustomerId(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Item object"  )  @Valid @RequestBody(required = false) Item item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Item> <id>aeiou</id> <quantity>123</quantity> <unitPrice>3.149</unitPrice> </Item>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api/v1/carts/{customerId}/items : Replace/add an item in shopping cart
     * Adds an item to the shopping cart if it doesn&#39;t already exist, or replace with given item if it does.
     *
     * @param customerId Customer Identifier (required)
     * @param item Item object (optional)
     * @return Item added successfully (status code 201)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Replace/add an item in shopping cart", nickname = "addOrReplaceItemsByCustomerId", notes = "Adds an item to the shopping cart if it doesn't already exist, or replace with given item if it does.", response = Item.class, responseContainer = "List", tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Item added successfully", response = Item.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Item object"  )  @Valid @RequestBody(required = false) Item item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>aeiou</id> <quantity>123</quantity> <unitPrice>3.149</unitPrice> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/carts/{customerId} : Delete the shopping cart
     * Deletes the shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 204)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Delete the shopping cart", nickname = "deleteCart", notes = "Deletes the shopping cart of given customer", tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteCart(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/carts/{customerId}/items/{itemId} : Delete the item from shopping cart
     * Deletes the item from shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @param itemId Item (product) Identifier (required)
     * @return Accepts the request, regardless of whether the specified item exists in the cart or not. (status code 202)
     */
    @ApiOperation(value = "Delete the item from shopping cart", nickname = "deleteItemFromCart", notes = "Deletes the item from shopping cart of given customer", tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepts the request, regardless of whether the specified item exists in the cart or not.") })
    @RequestMapping(value = "/api/v1/carts/{customerId}/items/{itemId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteItemFromCart(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Item (product) Identifier",required=true) @PathVariable("itemId") String itemId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/carts/{customerId} : Returns the shopping cart
     * Returns the shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 200)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns the shopping cart", nickname = "getCartByCustomerId", notes = "Returns the shopping cart of given customer", response = Cart.class, tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Cart.class),
        @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Cart> getCartByCustomerId(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"customerId\" : \"customerId\", \"id\" : \"id\", \"items\" : [ { \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" }, { \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>aeiou</id> <customerId>aeiou</customerId> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/carts/{customerId}/items : Returns the list of products in user&#39;s shopping cart
     * Returns the items in shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 200)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns the list of products in user's shopping cart", nickname = "getCartItemsByCustomerId", notes = "Returns the items in shopping cart of given customer", response = Item.class, responseContainer = "List", tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Item.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Given customer ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Item>> getCartItemsByCustomerId(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>aeiou</id> <quantity>123</quantity> <unitPrice>3.149</unitPrice> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/carts/{customerId}/items/{itemId} : Returns given item from user&#39;s shopping cart
     * Returns given item from shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @param itemId Item (product) Identifier (required)
     * @return If item exists in cart (status code 200)
     *         or Given item (product) ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns given item from user's shopping cart", nickname = "getCartItemsByItemId", notes = "Returns given item from shopping cart of given customer", response = Item.class, tags={ "cart", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "If item exists in cart", response = Item.class),
        @ApiResponse(code = 404, message = "Given item (product) ID doesn't exist") })
    @RequestMapping(value = "/api/v1/carts/{customerId}/items/{itemId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Item> getCartItemsByItemId(@ApiParam(value = "Customer Identifier",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Item (product) Identifier",required=true) @PathVariable("itemId") String itemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 6.027456183070403, \"quantity\" : 0, \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Item> <id>aeiou</id> <quantity>123</quantity> <unitPrice>3.149</unitPrice> </Item>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
