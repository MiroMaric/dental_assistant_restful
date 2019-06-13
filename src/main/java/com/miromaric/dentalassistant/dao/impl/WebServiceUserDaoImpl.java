package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.WebServiceUser;
import java.util.List;
import javax.persistence.EntityManager;

public class WebServiceUserDaoImpl extends AbstractDAO<WebServiceUser, String> {

    @Override
    protected WebServiceUser findExistingResource(WebServiceUser resource, EntityManager em) {
        return em.find(WebServiceUser.class, resource.getUsername());
    }

    @Override
    protected List<WebServiceUser> findAllResources(EntityManager em) {
        return em.createNamedQuery("WebServiceUser.getAll").getResultList();
    }

    @Override
    protected WebServiceUser findResourceById(String id, EntityManager em) {
        return em.find(WebServiceUser.class, id);
    }

    @Override
    protected void setIdToResource(WebServiceUser resource, String username) {
        resource.setUsername(username);
    }

}
