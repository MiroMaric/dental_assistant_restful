package com.miromaric.dentalassistant.security;

import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.model.WebServiceUser;
import com.miromaric.dentalassistant.service.impl.UserServiceImpl;
import java.util.List;

public class Security{
    
    private static Security instance;
    private final List<User> users;
    
    private Security() {
        //users = new WebServiceUserServiceImpl().getAll();
        users = new UserServiceImpl().getAll();
        
    }
    
    public static Security getInstance(){
        if(instance==null)
            instance = new Security();
        return instance;
    }

    public boolean isWebServiceUser(String username, String password) {
        WebServiceUser user = new WebServiceUser(username, password);
        return users.stream().anyMatch((u) -> (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())));
    }
    
}
