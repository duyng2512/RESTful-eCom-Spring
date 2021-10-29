/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.opw.modern.api;

import com.opw.modern.api.model.AddAddressReq;
import com.opw.modern.api.model.Address;
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
@Api(value = "Address", description = "the Address API")
public interface AddressApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/addresses : Creates a new user addresses
     * Creates a new user addresses. Does nothing if address already exists.
     *
     * @param addAddressReq  (optional)
     * @return For successful fetch. (status code 200)
     */
    @ApiOperation(value = "Creates a new user addresses", nickname = "createAddress", notes = "Creates a new user addresses. Does nothing if address already exists.", response = Address.class, tags={ "address", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful fetch.", response = Address.class) })
    @RequestMapping(value = "/api/v1/addresses",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Address> createAddress(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) AddAddressReq addAddressReq) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Address> <id>aeiou</id> <number>aeiou</number> <residency>aeiou</residency> <street>aeiou</street> <city>aeiou</city> <state>aeiou</state> <country>aeiou</country> <pincode>aeiou</pincode> </Address>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/addresses/{id} : Deletes user&#39;s address
     * Deletes user&#39;s address based on given address ID.
     *
     * @param id address Identifier (required)
     * @return Accepts the deletion request and perform deletion. If ID does not exist, does nothing. (status code 202)
     */
    @ApiOperation(value = "Deletes user's address", nickname = "deleteAddressesById", notes = "Deletes user's address based on given address ID.", tags={ "address", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepts the deletion request and perform deletion. If ID does not exist, does nothing.") })
    @RequestMapping(value = "/api/v1/addresses/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAddressesById(@ApiParam(value = "address Identifier",required=true) @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/addresses/{id} : Returns user&#39;s address
     * Returns user&#39;s address based on given address ID.
     *
     * @param id address Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @ApiOperation(value = "Returns user's address", nickname = "getAddressesById", notes = "Returns user's address based on given address ID.", response = Address.class, tags={ "address", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful fetch.", response = Address.class) })
    @RequestMapping(value = "/api/v1/addresses/{id}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Address> getAddressesById(@ApiParam(value = "address Identifier",required=true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Address> <id>aeiou</id> <number>aeiou</number> <residency>aeiou</residency> <street>aeiou</street> <city>aeiou</city> <state>aeiou</state> <country>aeiou</country> <pincode>aeiou</pincode> </Address>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/addresses : Returns all user&#39;s addresses
     * Returns all user&#39;s addresses, else empty collection
     *
     * @return For successful fetch. (status code 200)
     */
    @ApiOperation(value = "Returns all user's addresses", nickname = "getAllAddresses", notes = "Returns all user's addresses, else empty collection", response = Address.class, responseContainer = "List", tags={ "address", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "For successful fetch.", response = Address.class, responseContainer = "List") })
    @RequestMapping(value = "/api/v1/addresses",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Address>> getAllAddresses() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"residency\" : \"residency\", \"number\" : \"number\", \"country\" : \"country\", \"pincode\" : \"pincode\", \"city\" : \"city\", \"street\" : \"street\", \"id\" : \"id\", \"state\" : \"state\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Address> <id>aeiou</id> <number>aeiou</number> <residency>aeiou</residency> <street>aeiou</street> <city>aeiou</city> <state>aeiou</state> <country>aeiou</country> <pincode>aeiou</pincode> </Address>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
