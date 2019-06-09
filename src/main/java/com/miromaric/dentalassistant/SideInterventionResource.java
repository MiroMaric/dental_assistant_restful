package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.model.dto.SideInterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.SideInterventionService;
import com.miromaric.dentalassistant.service.impl.SideInterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.SideInterventionMapperImpl;
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

@Path("patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions")
public class SideInterventionResource {
    
    private @PathParam("patientId")Long patientId;
    private @PathParam("toothId")Long toothId;
    private @PathParam("toothSideId")Long toothSideId;
    
    private final SideInterventionService service = new SideInterventionServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<SideIntervention> interventions =  
                service.getAllPatientsToothSideInterventions(patientId,toothId,toothSideId);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long sideInterventionId){
        SideIntervention sideIntervention =  
                service.getPatientsToothSideIntervention(patientId,toothId,toothSideId,sideInterventionId);
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid SideInterventionDto sideInterventionDto){
        sideInterventionDto.setPatientID(patientId);
        sideInterventionDto.setToothID(toothId);
        sideInterventionDto.setToothSideID(toothSideId);
        service.save(new SideInterventionMapperImpl().toDataModel(sideInterventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, sideInterventionDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long sideInterventionId){
        SideIntervention sideIntervention = service.remove(sideInterventionId);
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long sideInterventionId,@Valid SideInterventionDto sideInterventionDto){
        sideInterventionDto.setPatientID(patientId);
        sideInterventionDto.setToothID(toothId);
        sideInterventionDto.setToothSideID(toothSideId);
        SideIntervention sideIntervention = service.update(sideInterventionId,new SideInterventionMapperImpl().toDataModel(sideInterventionDto));
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }
}
