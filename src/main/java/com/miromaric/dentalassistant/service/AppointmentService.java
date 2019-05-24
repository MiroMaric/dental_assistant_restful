package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.Appointment;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface AppointmentService {
    void save(Appointment appointment);
    List<Appointment> getAll();
    Appointment getOne(Long id);
    Appointment update(Long id,Appointment appointment);
    Appointment remove(Long id);
}
