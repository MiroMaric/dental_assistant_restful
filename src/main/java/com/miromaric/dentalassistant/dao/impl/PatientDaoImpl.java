package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.PatientDao;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 */
public class PatientDaoImpl implements PatientDao {

    @Override
    public void save(Patient patient) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Patient> getAll() {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Patient> patients = em.createNamedQuery("Patient.getAll").getResultList();
        em.close();
        return patients;
    }

    @Override
    public Patient getOne(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    @Override
    public Patient update(int id, Patient patient) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient dbPatient = em.find(Patient.class, id);
        if(dbPatient!=null){
            em.merge(patient);
            em.getTransaction().commit();
        }
        em.close();
        return dbPatient;
    }

    @Override
    public Patient remove(int id) {
        EntityManagerFactory emf = MyPersistence.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, id);
        if(patient!=null){
            em.remove(patient);
            em.getTransaction().commit();
        }
        em.close();
        return patient;
    }

}
