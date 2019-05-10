package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Patient;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface AppointmentService {
    void save(Appointment appointment);
    List<Appointment> getAll();
    Appointment getOne(int id);
    Appointment update(int id,Appointment appointment);
    Appointment remove(int id);
}
