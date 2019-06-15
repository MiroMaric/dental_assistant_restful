package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothInterventionDao;
import com.miromaric.dentalassistant.model.ToothIntervention;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;

public class ToothInterventionDaoImpl implements ToothInterventionDao {

    @Override
    public boolean save(ToothIntervention toothIntervention) {
        EntityManager em = MyPersistence.getInstance().getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(toothIntervention);
            em.getTransaction().commit();
            return true;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public List<ToothIntervention> getAll(Long patientId, Long toothId) {
        EntityManager em = MyPersistence.getInstance().getEntityManagerFactory().createEntityManager();
        return em.createNamedQuery("ToothIntervention.getAll", ToothIntervention.class)
                .setParameter("patientId", patientId)
                .setParameter("toothId", toothId)
                .getResultList();
    }

    @Override
    public ToothIntervention getOne(Long patientId, Long toothId, Long toothInterventionId) {
        EntityManager em = MyPersistence.getInstance().getEntityManagerFactory().createEntityManager();
        return em.createNamedQuery("ToothIntervention.getOne", ToothIntervention.class)
                .setParameter("patientId", patientId)
                .setParameter("toothId", toothId)
                .setParameter("interventionItemId", toothInterventionId)
                .getSingleResult();
    }
    
    
    @Override
    public ToothIntervention update(Long patientId, Long toothId, Long toothInterventionId, ToothIntervention ti) {
        EntityManager em = MyPersistence.getInstance().getEntityManagerFactory().createEntityManager();
        try {
            ToothIntervention dbTi = getOne(patientId, toothId, toothInterventionId);
            em.getTransaction().begin();
            if (dbTi != null) {
                ti.setItemID(dbTi.getItemID());
                em.merge(ti);
                em.getTransaction().commit();
            }
            return dbTi;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public ToothIntervention remove(Long patientId, Long toothId, Long toothInterventionId) {
        EntityManager em = MyPersistence.getInstance().getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            ToothIntervention dbTi = em.createNamedQuery("ToothIntervention.getOne", ToothIntervention.class)
                .setParameter("patientId", patientId)
                .setParameter("toothId", toothId)
                .setParameter("interventionItemId", toothInterventionId)
                .getSingleResult();
            if (dbTi != null) {
                em.remove(dbTi);
                em.getTransaction().commit();
            }
            return dbTi;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

}
