package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.PatientService;
import com.miromaric.dentalassistant.service.impl.PatientServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikoPC
 */
@Path("patients")
public class PatientResource {
    
    PatientService service = new PatientServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<Patient> patients =  service.getAll();
        return new MyResponse(Status.SUCCESS, patients, null);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id")int id){
        Patient patient =  service.getOne(id);
        return new MyResponse(Status.SUCCESS, patient, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse save(Patient patient){
        service.save(patient);
        return new MyResponse(Status.SUCCESS, patient, null);
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id")int id){
        Patient patient = service.remove(id);
        return new MyResponse(Status.SUCCESS, patient, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")int id,Patient patient){
        Patient uPatient = service.update(id,patient);
        return new MyResponse(Status.SUCCESS, uPatient, null);
    }
}
