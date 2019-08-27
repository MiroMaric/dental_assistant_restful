package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothStateService;
import com.miromaric.dentalassistant.service.impl.ToothStateServiceImpl;
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
 * Implementacija veb resursa - Stanje zuba. Klasa koristi JAX-RS anotacije kako
 * bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothState
 * @see MyResponse
 *
 */
@Path("toothStates")
public class ToothStateResource {

    private final ToothStateService service = new ToothStateServiceImpl();

    /**
     * Resurs metoda koja vraća sva stanja u kojima se može nalaziti zub.
     * Obrađuje HTTP GET toothStates zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih stanja u kojima se može
     * nalaziti zub
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothState> toothStates = service.getAll();
        return new MyResponse(Status.SUCCESS, toothStates, null);
    }

    /**
     * Resurs metoda koja vraća željeno stanje u kome se može nalaziti zub. Obrađuje HTTP GET
     * toothStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju stanja u kome se može nalaziti zub
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        ToothState toothState = service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothState, null);
    }

    /**
     * Resurs metoda koja kreira novo stanje u kome se može nalaziti zub. Obrađuje HTTP POST
     * toothStates zahtev.
     *
     * @param toothState Stanje zuba
     * @return Odgovor koji sadrži reprezentaciju novog stanja u kome se može
     * nalaziti zub
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothState toothState) {
        service.save(toothState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothState, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje stanja u kome se može nalaziti zub. Obrađuje HTTP DELETE
     * toothStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju obrisanog stanja u kome se može nalaziti zub
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        ToothState toothState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothState, null);
    }
    /**
     * Resurs metoda koja vrši izmenu stanja u kome se moće nalaziti zub. Obrađuje HTTP PUT
     * toothStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @param toothState Stanje zuba
     * @return Odgovor koji sadrži reprezentaciju izmenjenog stanja
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid ToothState toothState) {
        ToothState uToothState = service.update(id, toothState);
        return new MyResponse(Status.SUCCESS, uToothState, null);
    }
}
