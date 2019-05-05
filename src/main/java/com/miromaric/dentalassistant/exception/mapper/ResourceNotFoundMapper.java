package com.miromaric.dentalassistant.exception.mapper;

import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author MikoPC
 */
@Provider
public class ResourceNotFoundMapper implements ExceptionMapper<ResourceNotFoundException>{

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        MyResponse response = new MyResponse(Status.ERROR, null, "Resource not found");
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
    
}
