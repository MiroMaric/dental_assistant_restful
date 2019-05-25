package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothRootState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothRootStateService;
import com.miromaric.dentalassistant.service.impl.ToothRootStateServiceImpl;
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
@Path("toothRootStates")
public class ToothRootStateResource {
    private final ToothRootStateService service = new ToothRootStateServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothRootState> toothRootStates =  service.getAll();
        return new MyResponse(Status.SUCCESS, toothRootStates, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long id){
        ToothRootState toothRootState =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothRootState, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothRootState toothRootState){
        service.save(toothRootState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothRootState, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long id){
        ToothRootState toothRootState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothRootState, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid ToothRootState toothRootState){
        ToothRootState uToothRootState = service.update(id,toothRootState);
        return new MyResponse(Status.SUCCESS, uToothRootState, null);
    }
}
