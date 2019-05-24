package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AppointmentDao;
import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author MikoPC
 */
public class AppointmentDaoImpl implements AppointmentDao {

    @Override
    public boolean save(Appointment appointment) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, appointment.getPatient().getPatientID());
        User user = em.find(User.class, appointment.getUser().getUsername());
        if (patient == null || user == null) {
            em.close();
            return false;
        }
        appointment.setPatient(patient);
        appointment.setUser(user);
        Long maxId = em.createQuery("select max(a.appointmentID) from Appointment a", Long.class).getSingleResult();
        if (maxId != null) {
            appointment.setAppointmentID(maxId + 1);
        } else {
            appointment.setAppointmentID(new Long(1));
        }
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();
        return true;
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
    public Appointment getOne(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment appointment;
        try {
            appointment = (Appointment) em.createNamedQuery("Appointment.getById").setParameter("appointmentID", id).getSingleResult();
        } catch (NoResultException e) {
            em.close();
            return null;
        }
        em.close();
        return appointment;
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment dbAppointment;
        try {
            dbAppointment = (Appointment) em.createNamedQuery("Appointment.getById").setParameter("appointmentID", id).getSingleResult();
        } catch (NoResultException e) {
            em.close();
            return null;
        }
        appointment.setAppointmentID(dbAppointment.getAppointmentID());
        em.merge(appointment);
        em.getTransaction().commit();
        em.close();
        return dbAppointment;
    }

    @Override
    public Appointment remove(Long id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment appointment;
        try {
            appointment = (Appointment) em.createNamedQuery("Appointment.getById").setParameter("appointmentID", id).getSingleResult();
        } catch (NoResultException e) {
            em.close();
            return null;
        }
        em.remove(appointment);
        em.getTransaction().commit();
        em.close();
        return appointment;
    }

}
