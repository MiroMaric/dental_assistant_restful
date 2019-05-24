package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothRootLabelDao;
import com.miromaric.dentalassistant.model.ToothRootLabel;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class ToothRootLabelDaoImpl implements ToothRootLabelDao{

    @Override
    public void save(ToothRootLabel toothRootLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toothRootLabel);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ToothRootLabel> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ToothRootLabel> toothRootLabels = em.createNamedQuery("ToothRootLabel.getAll").getResultList();
        em.close();
        return toothRootLabels;
    }

    @Override
    public ToothRootLabel getOne(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothRootLabel toothRootLabel = em.find(ToothRootLabel.class, id);
        em.close();
        return toothRootLabel;
    }

    @Override
    public ToothRootLabel update(Long id, ToothRootLabel toothRootLabel) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothRootLabel dbToothRootLabel = em.find(ToothRootLabel.class, id);
        if(dbToothRootLabel!=null){
            toothRootLabel.setToothRootLabelID(dbToothRootLabel.getToothRootLabelID());
            em.merge(toothRootLabel);
            em.getTransaction().commit();
        }
        em.close();
        return dbToothRootLabel;
    }

    @Override
    public ToothRootLabel remove(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothRootLabel toothRootLabel = em.find(ToothRootLabel.class, id);
        if(toothRootLabel!=null){
            em.remove(toothRootLabel);
            em.getTransaction().commit();
        }
        em.close();
        return toothRootLabel;
    }
    
}
