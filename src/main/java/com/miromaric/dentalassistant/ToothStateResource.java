package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothStateService;
import com.miromaric.dentalassistant.service.impl.ToothStateServiceImpl;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author MikoPC
 */
@Path("toothStates")
public class ToothStateResource {
    private final ToothStateService service = new ToothStateServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothState> toothStates =  service.getAll();
        return new MyResponse(Status.SUCCESS, toothStates, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long id){
        ToothState toothState =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothState, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothState toothState){
        service.save(toothState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothState, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long id){
        ToothState toothState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothState, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid ToothState toothState){
        ToothState uToothState = service.update(id,toothState);
        return new MyResponse(Status.SUCCESS, uToothState, null);
    }
}
