package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.dto.AppointmentReq;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.AppointmentService;
import com.miromaric.dentalassistant.service.impl.AppointmentServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.AppointmentMapperImpl;
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
@Path("appointments")
public class AppointmentResource {

    private final AppointmentService service = new AppointmentServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<Appointment> appointments =  service.getAll();
        
        return new MyResponse(Status.SUCCESS,appointments , null);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public MyResponse getOne(@PathParam("id")Long id){
        Appointment appointment = service.getOne(id);
        System.out.println("----" + appointment);
        return new MyResponse(Status.SUCCESS,appointment, null);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid AppointmentReq appointmentReq){
        Appointment appointment = appointmentReq.getModel();
        service.save(appointment);
        System.out.println("----" + appointment);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, appointment, null)).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid AppointmentReq appointmentReq){
        Appointment appointment = service.update(id, appointmentReq.getModel());
        System.out.println("----" + appointment);
        return new MyResponse(Status.SUCCESS, appointment, null);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse remove(@PathParam("id")Long id){
        Appointment appointment = service.remove(id);
        System.out.println("----" + appointment);
        return new MyResponse(Status.SUCCESS, appointment, null);
    }
    

}
