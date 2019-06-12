package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.model.dto.RootInterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.RootInterventionService;
import com.miromaric.dentalassistant.service.impl.RootInterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.RootInterventionMapperImpl;
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

@Path("patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions")
public class RootInterventionResource {
    
    private @PathParam("patientId")Long patientId;
    private @PathParam("toothId")Long toothId;
    private @PathParam("toothRootId")Long toothRootId;
    
    private final RootInterventionService service = new RootInterventionServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<RootIntervention> interventions =  
                service.getAllPatientsToothRootInterventions(patientId,toothId,toothRootId);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long rootInterventionId){
        RootIntervention rootIntervention =  
                service.getPatientsToothRootIntervention(patientId,toothId,toothRootId,rootInterventionId);
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid RootInterventionDto rootInterventionDto){
        rootInterventionDto.setPatientID(patientId);
        rootInterventionDto.setToothID(toothId);
        rootInterventionDto.setToothRootID(toothRootId);
        service.save(new RootInterventionMapperImpl().toDataModel(rootInterventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, rootInterventionDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long rootInterventionId){
        RootIntervention rootIntervention = service.remove(rootInterventionId);
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long rootInterventionId,@Valid RootInterventionDto rootInterventionDto){
        rootInterventionDto.setPatientID(patientId);
        rootInterventionDto.setToothID(toothId);
        rootInterventionDto.setToothRootID(toothRootId);
        RootIntervention rootIntervention = service.update(rootInterventionId,new RootInterventionMapperImpl().toDataModel(rootInterventionDto));
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }
    
}
