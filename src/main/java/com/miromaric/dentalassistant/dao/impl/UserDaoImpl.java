package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.User;
import java.util.List;
import javax.persistence.EntityManager;

public class UserDaoImpl extends AbstractDAO<User, String> {

    @Override
    protected User findExistingResource(User resource, EntityManager em) {
        return em.find(User.class, resource.getUsername());
    }

    @Override
    protected List<User> findAllResources(EntityManager em) {
        return em.createNamedQuery("User.getAll").getResultList();
    }

    @Override
    protected User findResourceById(String id, EntityManager em) {
        return em.find(User.class, id);
    }

    @Override
    protected void setIdToResource(User resource, String key) {
        resource.setUsername(key);
    }

}
