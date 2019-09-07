package com.miromaric.dentalassistant.dao.impl;

import com.miromaric.dentalassistant.dao.AbstractDAO;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.Tooth;
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
        Patient patient = em.find(Patient.class, id);
        patient.getTeeth().forEach(t->{
            t.getToothInterventions().forEach(o->{});
            t.getToothRoots().forEach(tr -> {
                tr.getRootInterventions().forEach(o->{});
            });
            t.getToothSides().forEach(ts->{
                ts.getSideInterventions().forEach(o->{});
            });
        });
        return patient;
    }

    @Override
    protected void setIdToResource(Patient resource, Long key) {
        resource.setPatientID(key);
    }

}
