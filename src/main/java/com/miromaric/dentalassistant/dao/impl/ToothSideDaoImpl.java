package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothSide;
import java.util.List;
import javax.persistence.EntityManager;


public class ToothSideDaoImpl extends AbstractDAO<ToothSide,Long>{

    @Override
    protected ToothSide findExistingResource(ToothSide resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothSide> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothSide.getAll").getResultList();
    }

    @Override
    protected ToothSide findResourceById(Long id, EntityManager em) {
        return em.find(ToothSide.class, id);
    }

    @Override
    protected void setIdToResource(ToothSide resource, Long id) {
        resource.setToothSideID(id);
    }
    
}
