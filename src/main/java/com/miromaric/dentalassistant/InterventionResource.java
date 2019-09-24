package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.InterventionService;
import com.miromaric.dentalassistant.service.impl.InterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.InterventionMapperImpl;
import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implementacija veb resursa - Intervencija. Klasa koristi JAX-RS anotacije
 * kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see Intervention
 * @see InterventionDto
 * @see MyResponse
 */
@Path("interventions")
public class InterventionResource {

    private final InterventionService service = new InterventionServiceImpl();

    /**
     * Resurs metoda koja vraća sve(opciono isfiltrirane)intervencije Obrađuje
     * HTTP GET /interventions zahtev.
     *
     * @param fromDate Datum od
     * @param toDate Datum do
     * @param username Korisničko ime zubara
     * @return Odgovor koji sadrži reprezentaciju svih (opciono
     * isfiltriranih)intervencija
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(
            @QueryParam("fromDate") Long fromDate,
            @QueryParam("toDate") Long toDate,
            @QueryParam("dentist") String username
    ) {
        List<Intervention> interventions
                = service.getFiltered(fromDate == null ? null : new Date(fromDate), toDate == null ? null : new Date(toDate), username);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }

    /**
     * Resurs metoda koja vraća željenu intervenciju. Obrađuje HTTP GET
     * /interventions/{id} zahtev.
     *
     * @param id Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju intervencije
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        Intervention intervention = service.getOne(id);
        return new MyResponse(Status.SUCCESS, intervention, null);
    }

    /**
     * Resurs metoda koja kreira novu intervenciju. Obrađuje HTTP POST
     * /interventions zahtev.
     *
     * @param intervention intervencija
     * @return Odgovor koji sadrži reprezentaciju nove intervencije
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Intervention intervention) {
        System.out.println("==================================");
        System.out.println(intervention.getUser().getUsername());
        service.save(intervention);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, intervention, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje intervencije Obrađuje HTTP DELETE
     * /interventions/{id} zahtev.
     *
     * @param id Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju obrisane intervencije
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        Intervention intervention = service.remove(id);
        return new MyResponse(Status.SUCCESS, intervention, null);
    }

    /**
     * Resurs metoda koja vrši izmenu intervencije. Obrađuje HTTP POST
     * /interventions/{id} zahtev.
     *
     * @param id Jedinstveni identifikator intervencije
     * @param interventionDto intervencijaDTO)
     * @return odgovor koji sadrži reprezentaciju izmenjene intervencije
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid InterventionDto interventionDto) {
        Intervention intervention = service.update(id, new InterventionMapperImpl().toDataModel(interventionDto));
        return new MyResponse(Status.SUCCESS, intervention, null);
    }

}
