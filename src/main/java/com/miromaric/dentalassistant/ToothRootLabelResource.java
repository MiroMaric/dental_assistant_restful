package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothRootLabel;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothRootLabelService;
import com.miromaric.dentalassistant.service.impl.ToothRootLabelServiceImpl;
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
@Path("toothRootLabels")
public class ToothRootLabelResource {
    private final ToothRootLabelService service = new ToothRootLabelServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothRootLabel> toothRootLabels =  service.getAll();
        return new MyResponse(Status.SUCCESS, toothRootLabels, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long id){
        ToothRootLabel toothRootLabel =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothRootLabel, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothRootLabel toothRootLabel){
        service.save(toothRootLabel);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothRootLabel, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long id){
        ToothRootLabel toothRootLabel = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothRootLabel, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid ToothRootLabel toothRootLabel){
        ToothRootLabel uToothRootLabel = service.update(id,toothRootLabel);
        return new MyResponse(Status.SUCCESS, uToothRootLabel, null);
    }
}
