package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.UserService;
import com.miromaric.dentalassistant.service.impl.UserServiceImpl;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implementacija veb resursa - Doktor(korisnik sistema). Klasa koristi JAX-RS
 * anotacije kako bi obezbedila kreiranje veb resursa.
 *
 * @author Miro Marić
 * @see User
 * @see MyResponse
 */
@Path("users")
public class UserResource {

    private final UserService service = new UserServiceImpl();

    /**
     * Resurs metoda koja vraća sve doktore(korisnike sistema). Obrađuje HTTP
     * GET /users zahtev.
     *
     * @return Odgovor koji sadrži reprezentaciju svih doktora
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll() {
        List<User> users = service.getAll();
        return new MyResponse(Status.SUCCESS, users, null);
    }

    /**
     * Resurs metoda koja vraća željenog doktora. Obrađuje HTTP GET
     * /users/{username} zahtev.
     *
     * @param username Korisničko ime doktora(Korisnika sistema)
     * @return Odgovor koji sadrži reprezentaciju doktora
     */
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("username") String username) {
        User user = service.getOne(username);
        return new MyResponse(Status.SUCCESS, user, null);
    }

    /**
     * Resurs metoda koja kreira novog doktora(korisnika sistema). Obrađuje HTTP
     * POST /users zahtev.
     *
     * @param user Korisnik
     * @return Odgovor koji sadrži reprezentaciju novog korisnika
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid User user) {
        service.save(user);
        return Response.status(Response.Status.CREATED).entity(new MyResponse(Status.SUCCESS, user, null)).build();
    }

    /**
     * Resurs metoda koja vrši brisanje korisnika. Obrađuje HTTP DELETE
     * /users/{username} zahtev.
     *
     * @param username Korisničko ime doktora(Korisnika sistema)
     * @return Odgovor koji sadrži reprezentaciju obrisanog korisnika
     */
    @DELETE
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("username") String username) {
        User user = service.remove(username);
        return new MyResponse(Status.SUCCESS, user, null);
    }

    /**
     * Resurs metoda koja vrši izmenu korisnika. Obrađuje HTTP PUT
     * /users/{username} zahtev.
     *
     * @param username Korisničko ime doktora(Korisnika sistema)
     * @param user Korisnik
     * @return Odgovor koji sadrži reprezentaciju izmenjenog korisnika
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public MyResponse update(@PathParam("username") String username, @Valid User user) {
        User uUser = service.update(username, user);
        return new MyResponse(Status.SUCCESS, uUser, null);
    }

}
