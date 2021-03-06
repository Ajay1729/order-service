/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.order.client.bpmn.api;

import com.diviso.graeshoppe.order.client.bpmn.model.FormDataResponse;
import com.diviso.graeshoppe.order.client.bpmn.model.ProcessInstanceResponse;
import com.diviso.graeshoppe.order.client.bpmn.model.SubmitFormRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-01T11:49:01.976907+05:30[Asia/Kolkata]")

@Api(value = "Forms", description = "the Forms API")
public interface FormsApi {

    @ApiOperation(value = "Get form data", nickname = "getFormData", notes = "", response = FormDataResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Forms", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates that form data could be queried.", response = FormDataResponse.class),
        @ApiResponse(code = 404, message = "Indicates that form data could not be found.") })
    @RequestMapping(value = "/form/form-data",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<FormDataResponse> getFormData(@ApiParam(value = "The task id corresponding to the form data that needs to be retrieved.") @Valid @RequestParam(value = "taskId", required = false) String taskId,@ApiParam(value = "The process definition id corresponding to the start event form data that needs to be retrieved.") @Valid @RequestParam(value = "processDefinitionId", required = false) String processDefinitionId);


    @ApiOperation(value = "Submit task form data", nickname = "submitForm", notes = "", response = ProcessInstanceResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Forms", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates request was successful and the form data was submitted", response = ProcessInstanceResponse.class),
        @ApiResponse(code = 400, message = "Indicates an parameter was passed in the wrong format. The status-message contains additional information.") })
    @RequestMapping(value = "/form/form-data",
        produces = "application/json", 
        method = RequestMethod.POST)
    ResponseEntity<ProcessInstanceResponse> submitForm(@ApiParam(value = ""  )  @Valid @RequestBody SubmitFormRequest submitFormRequest);

}
