package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.model.dto.ToothInterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothInterventionService;
import com.miromaric.dentalassistant.service.impl.ToothInterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothInterventionMapperImpl;
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

@Path("patients/{patientId}/teeth/{toothId}/toothInterventions")
public class ToothInterventionResource {

    private @PathParam("patientId")Long patientId;
    private @PathParam("toothId")Long toothId;
    
    private final ToothInterventionService service = new ToothInterventionServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothIntervention> toothInterventions =  
                service.getAll(patientId, toothId);
        return new MyResponse(Status.SUCCESS, toothInterventions, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long toothInterventionId){
        ToothIntervention toothIntervention =  
                service.getOne(patientId, toothId, toothInterventionId);
        return new MyResponse(Status.SUCCESS, toothIntervention, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothInterventionDto toothInterventionDto){
        toothInterventionDto.setPatientID(patientId);
        toothInterventionDto.setToothID(toothId);
        service.save(new ToothInterventionMapperImpl().toDataModel(toothInterventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothInterventionDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long toothInterventionId){
        ToothIntervention toothIntervention = service.remove(patientId, toothId, toothInterventionId);
        return new MyResponse(Status.SUCCESS, toothIntervention, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long toothInterventionId,@Valid ToothInterventionDto toothInterventionDto){
        toothInterventionDto.setPatientID(patientId);
        toothInterventionDto.setToothID(toothId);
        toothInterventionDto.setToothInterventionID(toothInterventionId);
        ToothIntervention toothIntervention = service.update(patientId, toothId, toothInterventionId,
                new ToothInterventionMapperImpl().toDataModel(toothInterventionDto));
        return new MyResponse(Status.SUCCESS, toothIntervention, null);
    }
}
