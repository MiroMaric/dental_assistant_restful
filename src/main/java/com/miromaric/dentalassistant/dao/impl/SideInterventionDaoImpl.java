package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.SideIntervention;
import java.util.List;
import javax.persistence.EntityManager;

public class SideInterventionDaoImpl extends AbstractDAO<SideIntervention, Long>{

    @Override
    protected SideIntervention findExistingResource(SideIntervention resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<SideIntervention> findAllResources(EntityManager em) {
        return em.createNamedQuery("SideIntervention.getAll").getResultList();
    }

    @Override
    protected SideIntervention findResourceById(Long id, EntityManager em) {
        return em.find(SideIntervention.class, id);
    }

    @Override
    protected void setIdToResource(SideIntervention resource, Long id) {
        resource.setItemID(id);
    }
    
}
