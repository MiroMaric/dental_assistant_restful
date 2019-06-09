package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothRoot;
import java.util.List;
import javax.persistence.EntityManager;

public class ToothRootDaoImpl extends AbstractDAO<ToothRoot, Long>{

    @Override
    protected ToothRoot findExistingResource(ToothRoot resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothRoot> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothRoot.getAll").getResultList();
    }

    @Override
    protected ToothRoot findResourceById(Long id, EntityManager em) {
        return em.find(ToothRoot.class, id);
    }

    @Override
    protected void setIdToResource(ToothRoot resource, Long id) {
        resource.setToothRootID(id);
    }
    
}
