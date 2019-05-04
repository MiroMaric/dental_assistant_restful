/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miromaric.dentalassistant;

import com.miromaric.dentalassistant.dao.UserDao;
import com.miromaric.dentalassistant.dao.impl.UserDaoImpl;
import com.miromaric.dentalassistant.model.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikoPC
 */
@Path("users")
public class UserResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
        UserDao userDao = new UserDaoImpl();
        return userDao.getAll();
    }
    
}
