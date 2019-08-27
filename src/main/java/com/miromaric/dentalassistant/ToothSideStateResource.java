package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothSideStateService;
import com.miromaric.dentalassistant.service.impl.ToothSideStateServiceImpl;
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
 * Implementacija veb resursa - Stanje strane zuba. Klasa koristi JAX-RS
 * anotacije kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothSideState
 * @see MyResponse
 *
 */
@Path("toothSideStates")
public class ToothSideStateResource {

    private final ToothSideStateService service = new ToothSideStateServiceImpl();

    /**
     * Resurs metoda koja vraća sva stanja u kojima se može nalaziti strana
     * zuba. Obrađuje HTTP GET toothSideStates zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih stanja u kojima se može
     * nalaziti strana zuba
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothSideState> toothSideStates = service.getAll();
        return new MyResponse(Status.SUCCESS, toothSideStates, null);
    }

    /**
     * Resurs metoda koja vraća željeno stanje u kome se može nalaziti strana
     * zuba. Obrađuje HTTP GET toothSideStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju stanja u kome se može nalaziti
     * strana zuba
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        ToothSideState toothSideState = service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothSideState, null);
    }

    /**
     * Resurs metoda koja kreira novo stanje u kome se može nalaziti strana
     * zuba. Obrađuje HTTP POST toothSideStates zahtev.
     *
     * @param toothSideState Stanje strane
     * @return Odgovor koji sadrži reprezentaciju novog stanja u kome se može
     * nalaziti strana zuba
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothSideState toothSideState) {
        service.save(toothSideState);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothSideState, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje stanja u kome se može nalaziti strana
     * zuba. Obrađuje HTTP DELETE toothSideStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @return Odgovor koji sadrži reprezentaciju obrisanog stanja u kome se
     * može nalaziti strana zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        ToothSideState toothSideState = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothSideState, null);
    }

    /**
     * Resurs metoda koja vrši izmenu stanja u kome se moće nalaziti strana
     * zuba. Obrađuje HTTP PUT toothSideStates/{id} zahtev.
     *
     * @param id Jedinstveni identifikator stanja
     * @param toothSideState Stanje strane
     * @return Odgovor koji sadrži reprezentaciju izmenjenog stanja u kome se
     * može nalaziti strana zuba
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid ToothSideState toothSideState) {
        ToothSideState uToothSideState = service.update(id, toothSideState);
        return new MyResponse(Status.SUCCESS, uToothSideState, null);
    }

}
