package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;

public class DentistAppointmentsFilter extends FilterHandler<Appointment>{

    private final String username;

    public DentistAppointmentsFilter(String username, FilterHandler successor) {
        super(successor);
        this.username = username;
    }
    
    @Override
    protected List<Appointment> concreteFilter(List<Appointment> appointments) {
        if(username!=null){
            for(Iterator<Appointment> iter = appointments.listIterator();iter.hasNext();){
                if(!iter.next().getUser().getUsername().equals(username)){
                    iter.remove();
                }
            }
        }
        return appointments;
    }
    
}
