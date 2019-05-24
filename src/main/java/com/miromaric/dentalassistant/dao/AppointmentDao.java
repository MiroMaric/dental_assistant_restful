package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.Appointment;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface AppointmentDao {
    boolean save(Appointment appointment);
    List<Appointment> getAll();
    Appointment getOne(int id);
    Appointment update(int id,Appointment appointment);
    Appointment remove(int id);
}
