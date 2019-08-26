package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.dto.AppointmentReq;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.AppointmentService;
import com.miromaric.dentalassistant.service.impl.AppointmentServiceImpl;
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
 * Implementacija veb resursa - Zakazani termin.
 * Klasa koristi JAX-RS anotacije kako bi obezbedila kreiranje veb resursa.
 * @author Miro Marić
 * @see Appointment
 * @see AppointmentReq
 * @see MyResponse
 */
@Path("appointments")
public class AppointmentResource {

    private final AppointmentService service = new AppointmentServiceImpl();
    
    /**
     * Resurs metoda koja vraća sve zakazane termine.
     * Obrađuje HTTP GET /appointments zahtev.
     * @return Odgovor koji sadrži reprezentaciju svih zakazanih termina
     * 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<Appointment> appointments =  service.getAll();
        return new MyResponse(Status.SUCCESS,appointments , null);
    }
    
    /**
     * Resurs metoda koja vraća željeni zakazani termin.
     * Obrađuje HTTP GET /appointments/{id} zahtev.
     * @param id Jedinstveni identifikator zakazanog termina
     * @return Odgovor koji sadrži reprezentaciju zakazanog termina
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public MyResponse getOne(@PathParam("id")Long id){
        Appointment appointment = service.getOne(id);
        return new MyResponse(Status.SUCCESS,appointment, null);
    }
    
    /**
     * Resurs metoda koja kreira novi zakazani termin.
     * Obrađuje HTTP POST /appointments zahtev.
     * @param appointmentReq zakazani termin(DTO)
     * @return Odgovor koji sadrži reprezentaciju novog zakazanog termina
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid AppointmentReq appointmentReq){
        Appointment appointment = appointmentReq.getModel();
        service.save(appointment);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, appointment, null)).build();
    }
    
    /**
     * Resurs metoda koja vrši izmenu zakazong termina.
     * Obrađuje HTTP PUT /appointments/{id} zahtev.
     * @param id Jedinstveni identifikator zakazanog termina
     * @param appointmentReq zakazani termin(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjenog zakazanog termina
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id")Long id,@Valid AppointmentReq appointmentReq){
        Appointment appointment = service.update(id, appointmentReq.getModel());
        return new MyResponse(Status.SUCCESS, appointment, null);
    }
    
    /**
     * Resurs metoda koja vrši brisanje zakazong termina.
     * Obrađuje HTTP DELETE /appointments/{id} zahtev.
     * @param id Jedinstveni identifikator zakazanog termina
     * @return Odgovor koji sadrži reprezentaciju obrisanog zakazanog termina
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse remove(@PathParam("id")Long id){
        Appointment appointment = service.remove(id);
        return new MyResponse(Status.SUCCESS, appointment, null);
    }
    

}
