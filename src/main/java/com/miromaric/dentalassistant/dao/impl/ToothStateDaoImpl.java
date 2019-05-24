package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.ToothStateDao;
import com.miromaric.dentalassistant.model.ToothState;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class ToothStateDaoImpl implements ToothStateDao {

    @Override
    public void save(ToothState toothState) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toothState);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ToothState> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ToothState> toothStates = em.createNamedQuery("ToothState.getAll").getResultList();
        em.close();
        return toothStates;
    }

    @Override
    public ToothState getOne(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothState toothState = em.find(ToothState.class, id);
        em.close();
        return toothState;
    }

    @Override
    public ToothState update(Long id, ToothState toothState) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothState dbToothState = em.find(ToothState.class, id);
        if(dbToothState!=null){
            toothState.setToothStateID(dbToothState.getToothStateID());
            em.merge(toothState);
            em.getTransaction().commit();
        }
        em.close();
        return dbToothState;
    }

    @Override
    public ToothState remove(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ToothState toothState = em.find(ToothState.class, id);
        if(toothState!=null){
            em.remove(toothState);
            em.getTransaction().commit();
        }
        em.close();
        return toothState;
    }

}
