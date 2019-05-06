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
    Patient getOne(int id);
    Patient update(int id,Patient patient);
    Patient remove(int id);
}
