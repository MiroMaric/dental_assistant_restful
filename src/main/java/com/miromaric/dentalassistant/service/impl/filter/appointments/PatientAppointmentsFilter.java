package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;

public final class PatientAppointmentsFilter extends FilterHandler<Appointment>{

    private final Long patientId;

    public PatientAppointmentsFilter(Long patientId, FilterHandler successor) {
        super(successor);
        this.patientId = patientId;
    }
    
    @Override
    protected List<Appointment> concreteFilter(List<Appointment> appointments) {
        if(patientId!=null){
            for(Iterator<Appointment> iter = appointments.listIterator();iter.hasNext();){
                if(iter.next().getPatient().getPatientID().longValue() != patientId.longValue()){
                    iter.remove();
                }
            }
        }
        return appointments;
    }
    
}
