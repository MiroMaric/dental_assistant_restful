package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothLabelDao;
import com.miromaric.dentalassistant.model.ToothLabel;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Tatjana
 */
public class ToothLabelDaoImpl implements ToothLabelDao{

    @Override
    public void save(ToothLabel toothLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toothLabel);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ToothLabel> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ToothLabel> toothLabels = em.createNamedQuery("ToothLabel.getAll").getResultList();
        em.close();
        return toothLabels;
    }

    @Override
    public ToothLabel getOne(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothLabel toothLabel = em.find(ToothLabel.class, id);
        em.close();
        return toothLabel;
    }

    @Override
    public ToothLabel update(int id, ToothLabel toothLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothLabel dbToothLabel = em.find(ToothLabel.class, id);
        if(dbToothLabel!=null){
            toothLabel.setToothLabelID(dbToothLabel.getToothLabelID());
            em.merge(toothLabel);
            em.getTransaction().commit();
        }
        em.close();
        return dbToothLabel;
    }

    @Override
    public ToothLabel remove(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothLabel toothLabel = em.find(ToothLabel.class, id);
        if(toothLabel!=null){
            em.remove(toothLabel);
            em.getTransaction().commit();
        }
        em.close();
        return toothLabel;
    }
    
}
