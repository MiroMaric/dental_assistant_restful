package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothSideLabelDao;
import com.miromaric.dentalassistant.model.ToothSideLabel;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class ToothSideLabelDaoImpl implements ToothSideLabelDao{

    @Override
    public void save(ToothSideLabel toothSideLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toothSideLabel);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ToothSideLabel> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ToothSideLabel> toothSideLabels = em.createNamedQuery("ToothSideLabel.getAll").getResultList();
        em.close();
        return toothSideLabels;
    }

    @Override
    public ToothSideLabel getOne(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideLabel toothSideLabel = em.find(ToothSideLabel.class, id);
        em.close();
        return toothSideLabel;
    }

    @Override
    public ToothSideLabel update(Long id, ToothSideLabel toothSideLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideLabel dbToothSideLabel = em.find(ToothSideLabel.class, id);
        if(dbToothSideLabel!=null){
            toothSideLabel.setToothSideLabelID(dbToothSideLabel.getToothSideLabelID());
            em.merge(toothSideLabel);
            em.getTransaction().commit();
        }
        em.close();
        return dbToothSideLabel;
    }

    @Override
    public ToothSideLabel remove(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideLabel toothSideLabel = em.find(ToothSideLabel.class, id);
        if(toothSideLabel!=null){
            em.remove(toothSideLabel);
            em.getTransaction().commit();
        }
        em.close();
        return toothSideLabel;
    }
    
}
