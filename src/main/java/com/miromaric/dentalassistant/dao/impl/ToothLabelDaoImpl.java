package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.ToothLabel;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tatjana
 */
public class ToothLabelDaoImpl extends AbstractDAO<ToothLabel, Long>{

    @Override
    protected ToothLabel findExistingResource(ToothLabel resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<ToothLabel> findAllResources(EntityManager em) {
        return em.createNamedQuery("ToothLabel.getAll").getResultList();
    }

    @Override
    protected ToothLabel findResourceById(Long id, EntityManager em) {
        return em.find(ToothLabel.class, id);
    }

    @Override
    protected void setIdToResource(ToothLabel resource, Long key) {
        resource.setToothLabelID(key);
    }
    
}
