package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import com.miromaric.dentalassistant.service.UserService;
import com.miromaric.dentalassistant.service.impl.UserServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikoPC
 */
@Path("users")
public class UserResource {
    
    UserService service = new UserServiceImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getAll(){
        List<User> users =  service.getAll();
        return new MyResponse(Status.SUCCESS, users, null);
    }
    
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse getOne(@PathParam("username")String username){
        User user =  service.getOne(username);
        return new MyResponse(Status.SUCCESS, user, null);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse save(User user){
        service.save(user);
        return new MyResponse(Status.SUCCESS, user, null);
    }
    
    @DELETE
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyResponse remove(@PathParam("username")String username){
        User user = service.remove(username);
        return new MyResponse(Status.SUCCESS, user, null);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public MyResponse update(@PathParam("username")String username,User user){
        User uUser = service.update(username,user);
        return new MyResponse(Status.SUCCESS, uUser, null);
    }
    
}
