package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.InterventionService;
import com.miromaric.dentalassistant.service.impl.InterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.InterventionMapperImpl;
import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author MikoPC
 */
@Path("interventions")
public class InterventionResource {
    
    private final InterventionService service = new InterventionServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(
            @QueryParam("fromDate") Long fromDate,
            @QueryParam("toDate") Long toDate,
            @QueryParam("dentist") String username
    ){
        System.out.println("\n\n\n" + fromDate);
        System.out.println(toDate);
        System.out.println(username);
        List<Intervention> interventions = 
                service.getFiltered(fromDate==null?null:new Date(fromDate), toDate==null?null:new Date(toDate),username);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long id){
        Intervention intervention =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, intervention, null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid InterventionDto interventionDto){
        service.save(new InterventionMapperImpl().toDataModel(interventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, interventionDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long id){
        Intervention intervention = service.remove(id);
        return new MyResponse(Status.SUCCESS, intervention, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid InterventionDto interventionDto){
        Intervention intervention = service.update(id,new InterventionMapperImpl().toDataModel(interventionDto));
        return new MyResponse(Status.SUCCESS, intervention, null);
    }
    
    
}
