package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.AppointmentService;
import com.miromaric.dentalassistant.service.impl.AppointmentServiceImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikoPC
 */
@Path("appointments")
public class AppointmentResource {

    private AppointmentService service = new AppointmentServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<Appointment> appointments =  service.getAll();
        return new MyResponse(Status.SUCCESS, appointments, null);
    }

}
