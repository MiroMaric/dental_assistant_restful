package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothSideStateService;
import com.miromaric.dentalassistant.service.impl.ToothSideStateServiceImpl;
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
@Path("toothSideStates")
public class ToothSideStateResource {
    private final ToothSideStateService service = new ToothSideStateServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothSideState> toothSideStates =  service.getAll();
        return new MyResponse(Status.SUCCESS, toothSideStates, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long id){
        ToothSideState toothSideState =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothSideState, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothSideState toothSideState){
        service.save(toothSideState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothSideState, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long id){
        ToothSideState toothSideState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothSideState, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid ToothSideState toothSideState){
        ToothSideState uToothSideState = service.update(id,toothSideState);
        return new MyResponse(Status.SUCCESS, uToothSideState, null);
    }
    
}
