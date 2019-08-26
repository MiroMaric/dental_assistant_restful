package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.PatientService;
import com.miromaric.dentalassistant.service.impl.PatientServiceImpl;
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
 * Implementacija veb resursa - Pacijent. Klasa koristi JAX-RS anotacije kako bi
 * obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see Patient
 * @see MyResponse
 */
@Path("patients")
public class PatientResource {

    private final PatientService service = new PatientServiceImpl();

    /**
     * Resurs metoda koja vraća sve pacijente. Obrađuje HTTP GET /patients
     * zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih pacijenata
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<Patient> patients = service.getAll();
        return new MyResponse(Status.SUCCESS, patients, null);
    }

    /**
     * Resurs metoda koja vraća željenog pacijenta. Obrađuje HTTP GET
     * /patients/{id} zahtev.
     *
     * @param id Jedinstveni identifikator pacijenta
     * @return Odgovor koji sadrži reprezentaciju pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        Patient patient = service.getOne(id);
        return new MyResponse(Status.SUCCESS, patient, null);
    }

    /**
     * Resurs metoda koja kreira novog pacijenta. Obrađuje HTTP POST /patients
     * zahtev.
     *
     * @param patient Pacijent
     * @return Odgovor koji sadrži reprezentaciju novog pacijenta
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid Patient patient) {
        service.save(patient);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, patient, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje pacijenta. Obrađuje HTTP DELETE
     * /patients/{id} zahtev.
     *
     * @param id Jedinstveni identifikator pacijenta
     * @return Odgovor koji sadrži reprezentaciju obrisanog pacijenta
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        Patient patient = service.remove(id);
        return new MyResponse(Status.SUCCESS, patient, null);
    }

    /**
     * Resurs metoda koja vrši izmenu pacijenta. Obrađuje HTTP PUT
     * /patients/{id} zahtev.
     *
     * @param id Jedinstveni identifikator pacijenta
     * @param patient Pacijent
     * @return Odgovor koji sadrži reprezentaciju izmenjenog pacijenta
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid Patient patient) {
        Patient uPatient = service.update(id, patient);
        return new MyResponse(Status.SUCCESS, uPatient, null);
    }
}
