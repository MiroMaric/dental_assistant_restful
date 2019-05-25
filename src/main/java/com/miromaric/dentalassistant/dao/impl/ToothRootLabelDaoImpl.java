package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothRootLabel;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothRootLabelDaoImpl extends AbstractDAO<ToothRootLabel, Long>{

    @Override
    protected ToothRootLabel findExistingResource(ToothRootLabel resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothRootLabel> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothRootLabel.getAll").getResultList();
    }

    @Override
    protected ToothRootLabel findResourceById(Long id, EntityManager em) {
        return em.find(ToothRootLabel.class, id);
    }

    @Override
    protected void setIdToResource(ToothRootLabel resource, Long key) {
        resource.setToothRootLabelID(key);
    }
    
    
}
