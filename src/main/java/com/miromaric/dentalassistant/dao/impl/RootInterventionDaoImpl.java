package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.RootIntervention;
import java.util.List;
import javax.persistence.EntityManager;

public class RootInterventionDaoImpl extends AbstractDAO<RootIntervention, Long>{

    @Override
    protected RootIntervention findExistingResource(RootIntervention resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<RootIntervention> findAllResources(EntityManager em) {
        return em.createNamedQuery("RootIntervention.getAll").getResultList();
    }

    @Override
    protected RootIntervention findResourceById(Long id, EntityManager em) {
        return em.find(RootIntervention.class, id);
    }

    @Override
    protected void setIdToResource(RootIntervention resource, Long id) {
        resource.setItemID(id);
    }
}
