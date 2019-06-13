package com.miromaric.dentalassistant.security;

import com.miromaric.dentalassistant.model.WebServiceUser;
import com.miromaric.dentalassistant.service.impl.WebServiceUserServiceImpl;
import java.util.List;

public class Security{
    
    private static Security instance;
    private final List<WebServiceUser> users;
    
    private Security() {
        users = new WebServiceUserServiceImpl().getAll();
    }
    
    public static Security getInstance(){
        if(instance==null)
            instance = new Security();
        return instance;
    }

    public boolean isWebServiceUser(String username, String password) {
        WebServiceUser user = new WebServiceUser(username, password);
        for(WebServiceUser u:users){
            if(u.equals(user))
                return true;
        }
        return false;
    }
    
}
