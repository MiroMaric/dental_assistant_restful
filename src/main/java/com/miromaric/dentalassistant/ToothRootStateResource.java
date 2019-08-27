package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothRootState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothRootStateService;
import com.miromaric.dentalassistant.service.impl.ToothRootStateServiceImpl;
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
 * Implementacija veb resursa - Stanje korena. Klasa koristi JAX-RS anotacije
 * kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothRootState
 * @see MyResponse
 *
 */
@Path("toothRootStates")
public class ToothRootStateResource {

    private final ToothRootStateService service = new ToothRootStateServiceImpl();

    /**
     * Resurs metoda koja vraća sva stanja u kojima se može nalaziti koren zuba.
     * Obrađuje HTTP GET toothRootStates zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih stanja u kojima se može
     * nalaziti koren zuba
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothRootState> toothRootStates = service.getAll();
        return new MyResponse(Status.SUCCESS, toothRootStates, null);
    }

    /**
     * Resurs metoda koja vraća željeno stanje u kome se može nalaziti koren
     * zuba. Obrađuje HTTP GET toothRootStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju stanja u kome se može nalaziti
     * koren zuba
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        ToothRootState toothRootState = service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothRootState, null);
    }

    /**
     * Resurs metoda koja kreira novo stanje u kome se može nalaziti koren zuba.
     * Obrađuje HTTP POST toothRootStates zahtev.
     *
     * @param toothRootState Stanje korena
     * @return Odgovor koji sadrži reprezentaciju novog stanja u kome se može
     * nalaziti koren zuba
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothRootState toothRootState) {
        service.save(toothRootState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothRootState, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje stanja u kome se može nalaziti koren
     * zuba. Obrađuje HTTP DELETE toothRootStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju obrisanog stanja u kome se
     * može nalaziti koren zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        ToothRootState toothRootState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothRootState, null);
    }

    /**
     * Resurs metoda koja vrši izmenu stanja u kome se moće nalaziti koren zuba.
     * Obrađuje HTTP PUT toothRootStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @param toothRootState Stanje korena
     * @return Odgovor koji sadrži reprezentaciju izmenjenog stanja u kome se
     * može nalaziti koren zuba
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid ToothRootState toothRootState) {
        ToothRootState uToothRootState = service.update(id, toothRootState);
        return new MyResponse(Status.SUCCESS, uToothRootState, null);
    }
}
