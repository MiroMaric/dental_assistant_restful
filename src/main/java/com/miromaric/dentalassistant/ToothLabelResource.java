package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothLabelService;
import com.miromaric.dentalassistant.service.impl.ToothLabelServiceImpl;
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
 * @author Tatjana
 */
@Path("toothLabels")
public class ToothLabelResource {

    private final ToothLabelService service = new ToothLabelServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothLabel> toothLabels =  service.getAll();
        return new MyResponse(Status.SUCCESS, toothLabels, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")int id){
        ToothLabel toothLabel =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothLabel, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothLabel toothLabel){
        service.save(toothLabel);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothLabel, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")int id){
        ToothLabel toothLabel = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothLabel, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")int id,@Valid ToothLabel toothLabel){
        ToothLabel uToothLabel = service.update(id,toothLabel);
        return new MyResponse(Status.SUCCESS, uToothLabel, null);
    }
}
