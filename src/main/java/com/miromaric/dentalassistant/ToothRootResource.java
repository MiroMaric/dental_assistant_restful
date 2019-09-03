package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothRoot;
import com.miromaric.dentalassistant.model.dto.ToothRootDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothRootService;
import com.miromaric.dentalassistant.service.impl.ToothRootServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothRootMapperImpl;
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
 * Implementacija veb resursa - Koren zuba. Klasa koristi JAX-RS anotacije kako
 * bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see ToothRoot
 * @see ToothRootDto
 * @see MyResponse
 */
@Path("patients/{patientId}/teeth/{toothId}/toothRoots")
public class ToothRootResource {

    /**
     * Jedinstveni identifikator pacijenta
     */
    private @PathParam("patientId")
    Long patientId;
    /**
     * Jedinstveni identifikator zuba
     */
    private @PathParam("toothId")
    Long toothId;

    private final ToothRootService service = new ToothRootServiceImpl();

    /**
     * Resurs metoda koja vraća sve korene zuba određenog pacijenta. Obrađuje
     * HTTP GET patients/{patientId}/teeth/{toothId}/toothRoots zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih korena zuba određenog
     * pacijenta
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothRoot> toothRoots = service.getAllPatientsToothRoots(patientId, toothId);
        return new MyResponse(Status.SUCCESS, toothRoots, null);
    }

    /**
     * Resurs metoda koja vraća željeni koren pacijenta. Obrađuje HTTP GET GET
     * patients/{patientId}/teeth/{toothId}/toothRoots/{id} zahtev.
     *
     * @param toothRootId Jedinstveni identifikator korena
     * @return Odgovor koji sadrži reprezentaciju korena pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long toothRootId) {
        ToothRoot toothSide = service.getPatientsToothRoot(patientId, toothId, toothRootId);
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }

    /**
     * Resurs metoda koja kreira novi koren. Obrađuje HTTP POST
     * patients/{patientId}/teeth/{toothId}/toothRoots zahtev.
     *
     * @param toothRootDto Koren(DTO)
     * @return Odgovor koji sadrži reprezentaciju novog korena
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothRootDto toothRootDto) {
        toothRootDto.setToothID(toothId);
        toothRootDto.setPatientID(patientId);
        service.save(new ToothRootMapperImpl().toDataModel(toothRootDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothRootDto, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje korena. Obrađuje HTTP DELETE
     * patients/{patientId}/teeth/{toothId}/toothRoots/{id} zahtev.
     *
     * @param toothRootId Jedinstveni identifikator korena
     * @return Odgovor koji sadrži reprezentaciju obrisanog korena
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long toothRootId) {
        ToothRoot toothRoot = service.remove(toothRootId);
        return new MyResponse(Status.SUCCESS, toothRoot, null);
    }

    /**
     * Resurs metoda koja vrši izmenu korena. Obrađuje HTTP PUT
     * patients/{patientId}/teeth/{toothId}/toothRoots/{id} zahtev.
     *
     * @param toothRootId Jedinstveni identifikator korena
     * @param toothRootDto Koren(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjenog korena
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long toothRootId, @Valid ToothRootDto toothRootDto) {
        toothRootDto.setToothID(toothId);
        toothRootDto.setPatientID(patientId);
        ToothRoot toothRoot = service.update(toothRootId, new ToothRootMapperImpl().toDataModel(toothRootDto));
        return new MyResponse(Status.SUCCESS, toothRoot, null);
    }

}
