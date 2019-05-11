/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miromaric.dentalassistant.exception.mapper;

import com.miromaric.dentalassistant.exception.IllegalRequestException;
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
public class IllegalRequestMapper implements ExceptionMapper<IllegalRequestException>{

    @Override
    public Response toResponse(IllegalRequestException e) {
        MyResponse response = new MyResponse(Status.ERROR, null, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
    
}
