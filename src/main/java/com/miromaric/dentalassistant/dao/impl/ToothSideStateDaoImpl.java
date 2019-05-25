package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothSideStateDao;
import com.miromaric.dentalassistant.model.ToothSideState;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class ToothSideStateDaoImpl implements ToothSideStateDao{

    @Override
    public void save(ToothSideState toothSideState) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toothSideState);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ToothSideState> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ToothSideState> toothSideStates = em.createNamedQuery("ToothSideState.getAll").getResultList();
        em.close();
        return toothSideStates;
    }

    @Override
    public ToothSideState getOne(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideState toothSideState = em.find(ToothSideState.class, id);
        em.close();
        return toothSideState;
    }

    @Override
    public ToothSideState update(Long id, ToothSideState toothSideState) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideState dbToothSideState = em.find(ToothSideState.class, id);
        if(dbToothSideState!=null){
            toothSideState.setToothSideStateID(dbToothSideState.getToothSideStateID());
            em.merge(toothSideState);
            em.getTransaction().commit();
        }
        em.close();
        return dbToothSideState;
    }

    @Override
    public ToothSideState remove(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothSideState toothSideState = em.find(ToothSideState.class, id);
        if(toothSideState!=null){
            em.remove(toothSideState);
            em.getTransaction().commit();
        }
        em.close();
        return toothSideState;
    }
    
}
