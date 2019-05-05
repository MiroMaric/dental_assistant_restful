package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.UserDao;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User user) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User dbUser = em.find(User.class, user.getUsername());
        if (dbUser == null) {
            em.persist(user);
            em.getTransaction().commit();
        }
        em.close();
        return dbUser==null?true:false;
    }

    @Override
    public List<User> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        em.close();
        return users;
    }

    @Override
    public User getOne(String username){
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, username);      
        em.close();
        return user;
    }

    @Override
    public User update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User remove(String username) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, username);
        if(user!=null){
            em.remove(user);
            em.getTransaction().commit();
        }
        em.close();
        return user!=null?user:null;
    }

}
