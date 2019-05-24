package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.PatientDao;
import com.miromaric.dentalassistant.dao.impl.PatientDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.service.PatientService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class PatientServiceImpl implements PatientService{

    PatientDao dao = new PatientDaoImpl();
    
    @Override
    public void save(Patient patient) {
        dao.save(patient);
    }

    @Override
    public List<Patient> getAll() {
        return dao.getAll();
    }

    @Override
    public Patient getOne(Long id) {
        Patient patient = dao.getOne(id);
        if(patient!=null)
            return patient;
        throw new ResourceNotFoundException("Patient not found");
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient dbPatient = dao.update(id, patient);
        if(dbPatient!=null)
            return dbPatient;
        throw new ResourceNotFoundException("Patient not found");
    }

    @Override
    public Patient remove(Long id) {
        Patient patient = dao.remove(id);
        if(patient!=null)
            return patient;
        throw new ResourceNotFoundException("Patient not found");
    }
    
}
