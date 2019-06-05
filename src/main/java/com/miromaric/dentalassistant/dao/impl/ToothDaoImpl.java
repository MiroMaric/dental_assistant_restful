package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.Tooth;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class ToothDaoImpl extends AbstractDAO<Tooth, Long>{

    @Override
    protected Tooth findExistingResource(Tooth resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<Tooth> findAllResources(EntityManager em) {
        return em.createNamedQuery("Tooth.getAll").getResultList();
    }

    @Override
    protected Tooth findResourceById(Long id, EntityManager em) {
        return em.find(Tooth.class, id);
    }

    @Override
    protected void setIdToResource(Tooth tooth, Long key) {
        tooth.setToothID(key);
    }
    
}
