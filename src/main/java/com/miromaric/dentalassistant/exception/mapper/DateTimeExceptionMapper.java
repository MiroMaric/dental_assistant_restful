package com.miromaric.dentalassistant.exception.mapper;

import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import java.time.DateTimeException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author MikoPC
 */
@Provider
public class DateTimeExceptionMapper implements ExceptionMapper<java.time.DateTimeException>{

    @Override
    public Response toResponse(DateTimeException arg0) {
        MyResponse response = new MyResponse(Status.ERROR, null, "Wrong date/time format");
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
    
}
