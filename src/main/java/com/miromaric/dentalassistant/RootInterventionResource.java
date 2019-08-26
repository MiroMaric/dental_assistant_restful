package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.RootIntervention;
import com.miromaric.dentalassistant.model.dto.RootInterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.RootInterventionService;
import com.miromaric.dentalassistant.service.impl.RootInterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.RootInterventionMapperImpl;
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
 * Implementacija veb resursa - Intervencija na korenu. Klasa koristi JAX-RS
 * anotacije kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see RootIntervention
 * @see RootInterventionDto
 * @see MyResponse
 */
@Path("patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions")
public class RootInterventionResource {

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
    /**
     * Jedinstveni identifikator korena zuba
     */
    private @PathParam("toothRootId")
    Long toothRootId;

    private final RootInterventionService service = new RootInterventionServiceImpl();

    /**
     * Resurs metoda koja vraća sve intervencije na korenu zuba. Obrađuje HTTP
     * GET
     * /patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions
     * zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih intervencija na korenu
     * zuba određenog pacijenta
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<RootIntervention> interventions
                = service.getAllPatientsToothRootInterventions(patientId, toothId, toothRootId);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }

    /**
     * Resurs metoda koja vraća željenu intervenciju. Obrađuje HTTP GET
     * /patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions/{id}
     *
     * @param rootInterventionId Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju intervencije na korenu zuba
     * određenog pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long rootInterventionId) {
        RootIntervention rootIntervention
                = service.getPatientsToothRootIntervention(patientId, toothId, toothRootId, rootInterventionId);
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }

    /**
     * Resurs metoda koja kreira novu intervenciju na korenu zuba. Obrađuje HTTP
     * POST
     * /patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions
     * zahtev.
     *
     * @param rootInterventionDto intervencija na korenu zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju nove intervencije na korenu
     * zuba određenog pacijenta
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid RootInterventionDto rootInterventionDto) {
        rootInterventionDto.setPatientID(patientId);
        rootInterventionDto.setToothID(toothId);
        rootInterventionDto.setToothRootID(toothRootId);
        service.save(new RootInterventionMapperImpl().toDataModel(rootInterventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, rootInterventionDto, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje intervencije na korenu zuba. Obrađuje
     * HTTP DELETE
     * /patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions/{id}
     * zahtev.
     *
     * @param rootInterventionId Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju obrisane intervencije na
     * korenu zuba određenog pacijenta
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long rootInterventionId) {
        RootIntervention rootIntervention = service.remove(rootInterventionId);
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }

    /**
     * Resurs metoda koja vrši izmenu intervencije na korenu zuba. Obrađuje HTTP
     * PUT
     * /patients/{patientId}/teeth/{toothId}/toothRoots/{toothRootId}/rootInterventions{id}
     * zahtev.
     *
     * @param rootInterventionId Jedinstveni identifikator intervencije
     * @param rootInterventionDto Intervencija na korenu zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjene intervencije na
     * korenu zuba određenog pacijenta
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long rootInterventionId, @Valid RootInterventionDto rootInterventionDto) {
        rootInterventionDto.setPatientID(patientId);
        rootInterventionDto.setToothID(toothId);
        rootInterventionDto.setToothRootID(toothRootId);
        RootIntervention rootIntervention = service.update(rootInterventionId, new RootInterventionMapperImpl().toDataModel(rootInterventionDto));
        return new MyResponse(Status.SUCCESS, rootIntervention, null);
    }

}
