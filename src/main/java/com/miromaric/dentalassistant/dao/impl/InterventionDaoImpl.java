package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.Intervention;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class InterventionDaoImpl extends AbstractDAO<Intervention, Long>{

    @Override
    protected Intervention findExistingResource(Intervention resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<Intervention> findAllResources(EntityManager em) {
        return em.createNamedQuery("Intervention.getAll").getResultList();
    }

    @Override
    protected Intervention findResourceById(Long id, EntityManager em) {
        return em.find(Intervention.class, id);
    }

    @Override
    protected void setIdToResource(Intervention resource, Long id) {
        resource.setInterventionID(id);
    }
    
}
