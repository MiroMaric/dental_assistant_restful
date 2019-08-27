package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.ToothSide;
import com.miromaric.dentalassistant.model.dto.ToothSideDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothSideService;
import com.miromaric.dentalassistant.service.impl.ToothSideServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothSideMapperImpl;
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
 * @see ToothSide
 * @see ToothSideDto
 * @see MyResponse
 */
@Path("patients/{patientId}/teeth/{toothId}/toothSides")
public class ToothSideResource {

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

    private final ToothSideService service = new ToothSideServiceImpl();

    /**
     * Resurs metoda koja vraća sve strane zuba određenog pacijenta. Obrađuje
     * HTTP GET patients/{patientId}/teeth/{toothId}/toothSides zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih strana zuba određenog
     * pacijenta
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<ToothSide> toothSides = service.getAllPatientsToothSides(patientId, toothId);
        return new MyResponse(Status.SUCCESS, toothSides, null);
    }

    /**
     * Resurs metoda koja vraća željenu stranu zuba pacijenta. Obrađuje HTTP GET
     * patients/{patientId}/teeth/{toothId}/toothSides/{id} zahtev.
     *
     * @param toothSideId Jedinstveni identifikator strane
     * @return Odgovor koji sadrži reprezentaciju strane zuba određenog
     * pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long toothSideId) {
        ToothSide toothSide = service.getPatientsToothSide(patientId, toothId, toothSideId);
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }

    /**
     * Resurs metoda koja kreira novu stranu zuba. Obrađuje HTTP POST
     * patients/{patientId}/teeth/{toothId}/toothSides zahtev.
     *
     * @param toothSideDto Strana zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju nove strane zuba
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothSideDto toothSideDto) {
        toothSideDto.setToothID(toothId);
        toothSideDto.setPatientID(patientId);
        service.save(new ToothSideMapperImpl().toDataModel(toothSideDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothSideDto, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje strane zuba. Obrađuje HTTP DELETE
     * patients/{patientId}/teeth/{toothId}/toothSides/{id} zahtev.
     *
     * @param toothSideId Jedinstveni identifikator strane
     * @return Odgovor koji sadrži reprezentaciju obrisane strane zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long toothSideId) {
        ToothSide toothSide = service.remove(toothSideId);
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }

    /**
     * Resurs metoda koja vrši izmenu strane zuba. Obrađuje HTTP PUT
     * patients/{patientId}/teeth/{toothId}/toothSides/{id} zahtev.
     *
     * @param toothSideId Jedinstveni identifikator strane
     * @param toothSideDto Strana zuba(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjene strane zuba
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long toothSideId, @Valid ToothSideDto toothSideDto) {
        toothSideDto.setToothID(toothId);
        toothSideDto.setPatientID(patientId);
        ToothSide toothSide = service.update(toothSideId, new ToothSideMapperImpl().toDataModel(toothSideDto));
        return new MyResponse(Status.SUCCESS, toothSide, null);
    }
}
