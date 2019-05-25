package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothState;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothStateDaoImpl extends AbstractDAO<ToothState, Long> {

    @Override
    protected ToothState findExistingResource(ToothState resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothState> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothState.getAll").getResultList();
    }

    @Override
    protected ToothState findResourceById(Long id, EntityManager em) {
        return em.find(ToothState.class, id);
    }

    @Override
    protected void setIdToResource(ToothState resource, Long key) {
        resource.setToothStateID(key);
    }

}
