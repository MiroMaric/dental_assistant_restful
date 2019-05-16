package com.miromaric.dentalassistant.exception.mapper;

import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import javax.json.bind.JsonbException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Tatjana
 */
@Provider
public class JsonbExceptionMapper implements ExceptionMapper<JsonbException>{

    @Override
    public Response toResponse(JsonbException e) {
        MyResponse response = new MyResponse(Status.ERROR, null, "Request body format is wrong");
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
    
}
