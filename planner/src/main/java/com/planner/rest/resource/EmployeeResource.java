package com.planner.rest.resource;

import com.planner.entities.Employee;
import com.planner.rest.bo.ServiceStatus;
import com.planner.services.bl.EmployeeBlService;
import com.planner.util.Constants;
import com.planner.util.Converter;
import com.planner.util.MessageUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Consumes("application/json")
public class EmployeeResource {

    @GET
    @Produces("application/json")
    public String getHello() {
        return "Hello World!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response empLogin(@QueryParam("name") String name) {

        ServiceStatus statusMessage = new ServiceStatus();
        MessageUtil messageUtil = new MessageUtil();
        String language = Constants.DEFAULT_LANG;

        try {
            if (name != null) {
                statusMessage = new EmployeeBlService().findEmployee(name);
                if (statusMessage.getStatusCode() == 0) {
                    statusMessage.setData(new Converter().employeeEntityToEmployeeBo((Employee) statusMessage.getData()));
                }
            } else {
                statusMessage.setStatusCode(1);
                statusMessage.setStatusMessage("EMPLOYEE_NAME_ISEMPTY");
                statusMessage.setData(null);
            }
        } catch (Exception e){
            statusMessage.setStatusCode(1);
            statusMessage.setStatusMessage(messageUtil.getMessage(language, "EXCEPTION_EMPLOYEE_DATA_PROBLEMS"));
            statusMessage.setData(null);
            return Response.status(Response.Status.OK).entity(statusMessage).build();
        }

        statusMessage.setStatusMessage(messageUtil.getMessage(language, statusMessage.getStatusMessage()));
        return Response.status(Response.Status.OK).entity(statusMessage).build();
    }

}
