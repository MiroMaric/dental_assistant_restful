package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AppointmentDao;
import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class AppointmentDaoImpl implements AppointmentDao{

    @Override
    public void save(Appointment appointment) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Appointment> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Appointment> appointments = em.createNamedQuery("Appointment.getAll").getResultList();
        em.close();
        return appointments;
    }

    @Override
    public Appointment getOne(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment appointment = em.find(Appointment.class, id);
        em.close();
        return appointment;
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment dbAppointment = em.find(Appointment.class, id);
        if(dbAppointment!=null){
            em.merge(appointment);
            em.getTransaction().commit();
        }
        em.close();
        return dbAppointment;
    }

    @Override
    public Appointment remove(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment dbAppointment = em.find(Appointment.class, id);
        if(dbAppointment!=null){
            em.remove(dbAppointment);
            em.getTransaction().commit();
        }
        em.close();
        return dbAppointment;
    }
    
}
