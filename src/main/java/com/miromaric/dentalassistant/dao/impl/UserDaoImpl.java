package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.UserDao;
import com.miromaric.dentalassistant.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UserDaoImpl implements UserDao{

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerokuDentalAssistantPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        em.close();
        emf.close();
        return users;
    }

    @Override
    public User getOne(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerokuDentalAssistantPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = (User)em.createNamedQuery("User.getByUsername").setParameter("username", username).getSingleResult();
        em.close();
        emf.close();
        return user;
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
