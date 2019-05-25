package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.Patient;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author MikoPC
 */
public class PatientDaoImpl extends AbstractDAO<Patient, Long> {

    @Override
    protected Patient findExistingResource(Patient resource, EntityManager em) {
        return null;
    }

    @Override
    protected List<Patient> findAllResources(EntityManager em) {
        return em.createNamedQuery("Patient.getAll").getResultList();
    }

    @Override
    protected Patient findResourceById(Long id, EntityManager em) {
        return em.find(Patient.class, id);
    }

    @Override
    protected void setIdToResource(Patient resource, Long key) {
        resource.setPatientID(key);
    }

}
