package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.dto.ToothDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothService;
import com.miromaric.dentalassistant.service.impl.ToothServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothMapperImpl;
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
@Path("patients/{patientId}/teeth")
public class ToothResource {
    
    @PathParam("patientId") private Long patientId;
    
    private final ToothService service = new ToothServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<Tooth> teeth =  service.getAllPatientsTeeth(patientId);
        return new MyResponse(Status.SUCCESS, teeth, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")Long toothId){
        Tooth tooth =  service.getPatientsTooth(patientId,toothId);
        return new MyResponse(Status.SUCCESS, tooth, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothDto toothDto){
        toothDto.setPatientID(patientId);
        service.save(new ToothMapperImpl().toDataModel(toothDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothDto, null)).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")Long toothId){
        Tooth tooth = service.remove(toothId);
        return new MyResponse(Status.SUCCESS, tooth, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long toothId,@Valid ToothDto toothDto){
        Tooth tooth = service.update(toothId, new ToothMapperImpl().toDataModel(toothDto));
        return new MyResponse(Status.SUCCESS, tooth, null);
    }
}
