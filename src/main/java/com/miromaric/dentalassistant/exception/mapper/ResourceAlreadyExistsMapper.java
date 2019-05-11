package com.miromaric.dentalassistant.exception.mapper;

import com.miromaric.dentalassistant.exception.ResourceAlreadyExistsException;
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
public class ResourceAlreadyExistsMapper implements ExceptionMapper<ResourceAlreadyExistsException>{

    @Override
    public Response toResponse(ResourceAlreadyExistsException e) {
        MyResponse response = new MyResponse(Status.ERROR, null, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
    
}
