package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.SideIntervention;
import com.miromaric.dentalassistant.model.dto.SideInterventionDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.SideInterventionService;
import com.miromaric.dentalassistant.service.impl.SideInterventionServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.SideInterventionMapperImpl;
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
 * Implementacija veb resursa - Intervencija na strani zuba. Klasa koristi
 * JAX-RS anotacije kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see SideIntervention
 * @see SideInterventionDto
 * @see MyResponse
 */
@Path("patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions")
public class SideInterventionResource {

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
     * Jedinstveni identifikator strane zuba
     */
    private @PathParam("toothSideId")
    Long toothSideId;

    private final SideInterventionService service = new SideInterventionServiceImpl();

    /**
     * Resurs metoda koja vraća sve intervencije na strani zuba. Obrađuje HTTP
     * GET
     * patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions
     * zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih intervencija na strani
     * zuba određenog pacijenta
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<SideIntervention> interventions
                = service.getAllPatientsToothSideInterventions(patientId, toothId, toothSideId);
        return new MyResponse(Status.SUCCESS, interventions, null);
    }

    /**
     * Resurs metoda koja vraća željenu intervenciju na strani zuba. Obrađuje
     * HTTP GET
     * patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions/{id}
     *
     * @param sideInterventionId Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju intervencije na strani zuba
     * određenog pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long sideInterventionId) {
        SideIntervention sideIntervention
                = service.getPatientsToothSideIntervention(patientId, toothId, toothSideId, sideInterventionId);
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }

    /**
     * Resurs metoda koja kreira novu intervenciju na strani zuba. Obrađuje HTTP
     * POST
     * patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions
     * zahtev.
     *
     * @param sideInterventionDto intervencija na strani zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju nove intervencije na strani
     * zuba određenog pacijenta
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid SideInterventionDto sideInterventionDto) {
        sideInterventionDto.setPatientID(patientId);
        sideInterventionDto.setToothID(toothId);
        sideInterventionDto.setToothSideID(toothSideId);
        service.save(new SideInterventionMapperImpl().toDataModel(sideInterventionDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, sideInterventionDto, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje intervencije na strani zuba. Obrađuje
     * HTTP DELETE
     * patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions/{id}
     * zahtev.
     *
     * @param sideInterventionId Jedinstveni identifikator intervencije
     * @return Odgovor koji sadrži reprezentaciju obrisane intervencije na
     * strani zuba određenog pacijenta
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long sideInterventionId) {
        SideIntervention sideIntervention = service.remove(sideInterventionId);
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }

    /**
     * Resurs metoda koja vrši izmenu intervencije na strani zuba. Obrađuje HTTP
     * PUT
     * patients/{patientId}/teeth/{toothId}/toothSides/{toothSideId}/sideInterventions/{id}
     * zahtev.
     *
     * @param sideInterventionId Jedinstveni identifikator intervencije
     * @param sideInterventionDto Intervencija na strani zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjene intervencije na
     * strani zuba određenog pacijenta
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long sideInterventionId, @Valid SideInterventionDto sideInterventionDto) {
        sideInterventionDto.setPatientID(patientId);
        sideInterventionDto.setToothID(toothId);
        sideInterventionDto.setToothSideID(toothSideId);
        SideIntervention sideIntervention = service.update(sideInterventionId, new SideInterventionMapperImpl().toDataModel(sideInterventionDto));
        return new MyResponse(Status.SUCCESS, sideIntervention, null);
    }
}
