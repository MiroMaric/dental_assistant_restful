package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothLabelService;
import com.miromaric.dentalassistant.service.impl.ToothLabelServiceImpl;
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
 * Implementacija veb resursa - Oznaka zuba. Klasa koristi JAX-RS anotacije kako
 * bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothLabel
 * @see MyResponse
 *
 */
@Path("toothLabels")
public class ToothLabelResource {

    private final ToothLabelService service = new ToothLabelServiceImpl();

    /**
     * Resurs metoda koja vraća sve oznake zuba. Obrađuje HTTP GET toothLabels
     * zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih oznaka zuba
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothLabel> toothLabels = service.getAll();
        return new MyResponse(Status.SUCCESS, toothLabels, null);
    }

    /**
     * Resurs metoda koja vraća željenu oznaku zuba. Obrađuje HTTP GET
     * toothLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @return Odgovor koji sadrži reprezentaciju oznake zuba
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        ToothLabel toothLabel = service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothLabel, null);
    }

    /**
     * Resurs metoda koja kreira novu oznaku zuba. Obrađuje HTTP POST
     * toothLabels zahtev.
     *
     * @param toothLabel Oznaka zuba
     * @return Odgovor koji sadrži reprezentaciju nove oznake
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothLabel toothLabel) {
        service.save(toothLabel);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothLabel, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje oznake zuba. Obrađuje HTTP DELETE
     * toothLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @return Odgovor koji sadrži reprezentaciju obrisane oznake zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        ToothLabel toothLabel = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothLabel, null);
    }

    /**
     * Resurs metoda koja vrši izmenu oznake zuba. Obrađuje HTTP PUT
     * toothLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @param toothLabel Oznaka zuba
     * @return Odgovor koji sadrži reprezentaciju izmenjene oznake
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid ToothLabel toothLabel) {
        ToothLabel uToothLabel = service.update(id, toothLabel);
        return new MyResponse(Status.SUCCESS, uToothLabel, null);
    }
}
