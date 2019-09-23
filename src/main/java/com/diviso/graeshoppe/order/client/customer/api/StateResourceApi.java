/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.order.client.customer.api;

import com.diviso.graeshoppe.order.client.customer.model.StateDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-09-23T15:56:07.947542+05:30[Asia/Kolkata]")

@Api(value = "StateResource", description = "the StateResource API")
public interface StateResourceApi {

    @ApiOperation(value = "createState", nickname = "createStateUsingPOST", notes = "", response = StateDTO.class, tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StateDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/states",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<StateDTO> createStateUsingPOST(@ApiParam(value = "stateDTO" ,required=true )  @Valid @RequestBody StateDTO stateDTO);


    @ApiOperation(value = "deleteState", nickname = "deleteStateUsingDELETE", notes = "", tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/states/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStateUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllStates", nickname = "getAllStatesUsingGET", notes = "", response = StateDTO.class, responseContainer = "List", tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StateDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/states",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StateDTO>> getAllStatesUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getState", nickname = "getStateUsingGET", notes = "", response = StateDTO.class, tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StateDTO.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/states/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<StateDTO> getStateUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "searchStates", nickname = "searchStatesUsingGET", notes = "", response = StateDTO.class, responseContainer = "List", tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StateDTO.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/_search/states",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<StateDTO>> searchStatesUsingGET(@NotNull @ApiParam(value = "query", required = true) @Valid @RequestParam(value = "query", required = true) String query,@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "updateState", nickname = "updateStateUsingPUT", notes = "", response = StateDTO.class, tags={ "state-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StateDTO.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/states",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<StateDTO> updateStateUsingPUT(@ApiParam(value = "stateDTO" ,required=true )  @Valid @RequestBody StateDTO stateDTO);

}
