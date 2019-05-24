package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.Patient;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface PatientService {
    void save(Patient patient);
    List<Patient> getAll();
    Patient getOne(Long id);
    Patient update(Long id,Patient patient);
    Patient remove(Long id);
}
