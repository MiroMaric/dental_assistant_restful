package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.Patient;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface PatientDao {
    void save(Patient patient);
    List<Patient> getAll();
    Patient getOne(Long id);
    Patient update(Long id,Patient patient);
    Patient remove(Long id);
}
