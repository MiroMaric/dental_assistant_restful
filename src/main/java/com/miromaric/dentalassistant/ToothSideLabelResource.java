package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothSideLabel;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothSideLabelService;
import com.miromaric.dentalassistant.service.impl.ToothSideLabelServiceImpl;
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
 * Implementacija veb resursa - Oznaka strane zuba. Klasa koristi JAX-RS
 * anotacije kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothSideLabel
 * @see MyResponse
 *
 */
@Path("toothSideLabels")
public class ToothSideLabelResource {

    private final ToothSideLabelService service = new ToothSideLabelServiceImpl();

    /**
     * Resurs metoda koja vraća sve oznake strana zuba. Obrađuje HTTP GET
     * toothSideLabels zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih oznaka strana zuba
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothSideLabel> toothSideLabels = service.getAll();
        return new MyResponse(Status.SUCCESS, toothSideLabels, null);
    }

    /**
     * Resurs metoda koja vraća željenu oznaku strane. Obrađuje HTTP GET
     * toothSideLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @return Odgovor koji sadrži reprezentaciju oznake strane
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long id) {
        ToothSideLabel toothSideLabel = service.getOne(id);
        return new MyResponse(Status.SUCCESS, toothSideLabel, null);
    }

    /**
     * Resurs metoda koja kreira novu oznaku strane. Obrađuje HTTP POST
     * toothSideLabels zahtev.
     *
     * @param toothSideLabel Oznaka strane zuba
     * @return Odgovor koji sadrži reprezentaciju nove oznake
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothSideLabel toothSideLabel) {
        service.save(toothSideLabel);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothSideLabel, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje oznake strane zuba. Obrađuje HTTP DELETE
     * toothSideLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @return Odgovor koji sadrži reprezentaciju obrisane oznake strane zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long id) {
        ToothSideLabel toothSideLabel = service.remove(id);
        return new MyResponse(Status.SUCCESS, toothSideLabel, null);
    }

    /**
     * Resurs metoda koja vrši izmenu oznake strane zuba. Obrađuje HTTP PUT
     * toothSideLabels/{id} zahtev.
     *
     * @param id Jedinstveni identifikator oznake
     * @param toothSideLabel Oznaka strane zuba
     * @return Odgovor koji sadrži reprezentaciju izmenjene oznake
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long id, @Valid ToothSideLabel toothSideLabel) {
        ToothSideLabel uToothSideLabel = service.update(id, toothSideLabel);
        return new MyResponse(Status.SUCCESS, uToothSideLabel, null);
    }

}
