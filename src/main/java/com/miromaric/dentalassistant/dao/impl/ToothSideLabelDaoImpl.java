package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothSideLabelDaoImpl extends AbstractDAO<ToothSideLabel, Long>{

    @Override
    protected ToothSideLabel findExistingResource(ToothSideLabel resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothSideLabel> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothSideLabel.getAll").getResultList();
    }

    @Override
    protected ToothSideLabel findResourceById(Long id, EntityManager em) {
        return em.find(ToothSideLabel.class, id);
    }

    @Override
    protected void setIdToResource(ToothSideLabel resource, Long key) {
        resource.setToothSideLabelID(key);
    }
    
}
