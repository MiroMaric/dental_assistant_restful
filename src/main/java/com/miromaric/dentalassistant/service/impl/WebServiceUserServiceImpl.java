package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.DAO;
import com.miromaric.dentalassistant.dao.impl.WebServiceUserDaoImpl;
import com.miromaric.dentalassistant.model.WebServiceUser;
import com.miromaric.dentalassistant.service.WebServiceUserService;
import java.util.List;

public class WebServiceUserServiceImpl implements WebServiceUserService{

    private final DAO<WebServiceUser,String> dao = new WebServiceUserDaoImpl();
    
    @Override
    public void save(WebServiceUser resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WebServiceUser> getAll() {
        return dao.getAll();
    }

    @Override
    public WebServiceUser getOne(String id) {
        return dao.getOne(id);
    }

    @Override
    public WebServiceUser update(String id, WebServiceUser resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WebServiceUser remove(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
