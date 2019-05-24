package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.AppointmentDao;
import com.miromaric.dentalassistant.dao.impl.AppointmentDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.AppointmentService;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public class AppointmentServiceImpl implements AppointmentService{

    AppointmentDao dao = new AppointmentDaoImpl();
    
    @Override
    public void save(Appointment appointment) {
        if(!dao.save(appointment))
            throw new ResourceNotFoundException("Patient or/and User not found");
    }

    @Override
    public List<Appointment> getAll() {
        return dao.getAll();
    }

    @Override
    public Appointment getOne(Long id) {
        Appointment appointment = dao.getOne(id);
        if(appointment!=null)
            return appointment;
        throw new ResourceNotFoundException("Appointment not found");
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment uAppointment = dao.update(id,appointment);
        if(uAppointment!=null)
            return uAppointment;
        throw new ResourceNotFoundException("Appointment not found");
    }

    @Override
    public Appointment remove(Long id) {
        Appointment appointment = dao.remove(id);
        if(appointment!=null)
            return appointment;
        throw new ResourceNotFoundException("Appointment not found");
    }
    
}
