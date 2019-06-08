package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.dto.ToothSideDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothSideService;
import com.miromaric.dentalassistant.service.impl.ToothSideServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothSideMapperImpl;
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

@Path("patients/{patientId}/teeth/{toothId}/toothSides")
public class ToothSideResource {
    
    private @PathParam("patientId")Long patientId;
    private @PathParam("toothId")Long toothId;
    
    private final ToothSideService service = new ToothSideServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<ToothSide> toothSides =  service.getAllPatientsToothSides(patientId,toothId);
        return new MyResponse(Status.SUCCESS, toothSides, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long toothSideId){
        ToothSide toothSide =  service.getPatientsToothSide(patientId,toothId,toothSideId);
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothSideDto toothSideDto){
        toothSideDto.setToothID(toothId);
        toothSideDto.setPatientID(patientId);
        service.save(new ToothSideMapperImpl().toDataModel(toothSideDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothSideDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long toothSideId){
        ToothSide toothSide = service.remove(toothSideId);
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long toothSideId,@Valid ToothSideDto toothSideDto){
        toothSideDto.setToothID(toothId);
        toothSideDto.setPatientID(patientId);
        ToothSide toothSide = service.update(toothSideId, new ToothSideMapperImpl().toDataModel(toothSideDto));
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }
}
