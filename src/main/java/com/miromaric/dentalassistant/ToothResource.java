package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.Tooth;
import com.miromaric.dentalassistant.model.dto.ToothDto;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.ToothService;
import com.miromaric.dentalassistant.service.impl.ToothServiceImpl;
import com.miromaric.dentalassistant.service.mapper.impl.ToothMapperImpl;
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
 * Implementacija veb resursa - Zub. Klasa koristi JAX-RS anotacije kako bi
 * obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see Tooth
 * @see ToothDto
 */
@Path("patients/{patientId}/teeth")
public class ToothResource {

    /**
     * Jedinstveni identifikator pacijenta
     */
    @PathParam("patientId")
    private Long patientId;

    private final ToothService service = new ToothServiceImpl();

    /**
     * Resurs metoda koja vraća sve zube pacijenta. Obrađuje HTTP GET
     * patients/{patientId}/teeth zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih zuba pacijenta
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<Tooth> teeth = service.getAllPatientsTeeth(patientId);
        return new MyResponse(Status.SUCCESS, teeth, null);
    }

    /**
     * Resurs metoda koja vraća željeni zub pacijenta. Obrađuje HTTP GET
     * patients/{patientId}/teeth/{id} zahtev.
     *
     * @param toothId Jedinstveni identifikator zuba
     * @return Odgovor koji sadrži reprezentaciju zuba pacijenta
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("id") Long toothId) {
        Tooth tooth = service.getPatientsTooth(patientId, toothId);
        return new MyResponse(Status.SUCCESS, tooth, null);
    }

    /**
     * Resurs metoda koja kreira novi zub. Obrađuje HTTP POST
     * patients/{patientId}/teeth zahtev.
     *
     * @param toothDto Zub(DTO)
     * @return Odgovor koji sadrži reprezentaciju novog zuba
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid ToothDto toothDto) {
        toothDto.setPatientID(patientId);
        service.save(new ToothMapperImpl().toDataModel(toothDto));
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, toothDto, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje zuba. Obrađuje HTTP DELETE
     * patients/{patientId}/teeth/{id} zahtev.
     *
     * @param toothId Jedinstveni identifikator zuba
     * @return Odgovor koji sadrži reprezentaciju obrisanog zuba
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("id") Long toothId) {
        Tooth tooth = service.remove(toothId);
        return new MyResponse(Status.SUCCESS, tooth, null);
    }

    /**
     * Resurs metoda koja vrši izmenu zuba. Obrađuje HTTP PUT
     * patients/{patientId}/teeth/{id} zahtev.
     *
     * @param toothId Jedinstveni identifikator zuba
     * @param toothDto Zub(DTO)
     * @return Odgovor koji sadrži reprezentaciju izmenjenog zuba
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public MyResponse update(@PathParam("id") Long toothId, @Valid ToothDto toothDto) {
        Tooth tooth = service.update(toothId, new ToothMapperImpl().toDataModel(toothDto));
        return new MyResponse(Status.SUCCESS, tooth, null);
    }
}
