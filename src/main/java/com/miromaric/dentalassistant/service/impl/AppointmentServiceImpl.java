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
        dao.save(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return dao.getAll();
    }

    @Override
    public Appointment getOne(int id) {
        Appointment appointment = dao.getOne(id);
        if(appointment!=null)
            return appointment;
        throw new ResourceNotFoundException("Resource not found");
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        Appointment uAppointment = dao.update(id,appointment);
        if(uAppointment!=null)
            return uAppointment;
        throw new ResourceNotFoundException("Resource not found");
    }

    @Override
    public Appointment remove(int id) {
        Appointment appointment = dao.remove(id);
        if(appointment!=null)
            return appointment;
        throw new ResourceNotFoundException("Resource not found");
    }
    
}
