package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothSideState;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothSideStateDaoImpl extends AbstractDAO<ToothSideState, Long>{

    @Override
    protected ToothSideState findExistingResource(ToothSideState resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothSideState> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothSideState.getAll").getResultList();
    }

    @Override
    protected ToothSideState findResourceById(Long id, EntityManager em) {
        return em.find(ToothSideState.class, id);
    }

    @Override
    protected void setIdToResource(ToothSideState resource, Long key) {
        resource.setToothSideStateID(key);
    }
    
}
