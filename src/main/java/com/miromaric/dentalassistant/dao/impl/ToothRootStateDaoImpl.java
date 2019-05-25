package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothRootState;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothRootStateDaoImpl extends AbstractDAO<ToothRootState, Long>{

    @Override
    protected ToothRootState findExistingResource(ToothRootState resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothRootState> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothRootState.getAll").getResultList();
    }

    @Override
    protected ToothRootState findResourceById(Long id, EntityManager em) {
        return em.find(ToothRootState.class, id);
    }

    @Override
    protected void setIdToResource(ToothRootState resource, Long key) {
        resource.setToothRootStateID(key);
    }

    
}
