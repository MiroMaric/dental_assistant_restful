package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;

/**
 * Implementrira filter za filtriranje liste zakazanih termina.
 * Filtriranje se vrši po jedinistvenom identifikatoru pacijenta.
 * @author Miro Marić
 * @see Appointment
 */
public final class PatientAppointmentsFilter extends FilterHandler<Appointment>{

    /**
     * Jedinsveni identifikator pacijenta po kome se vrši filtriranje
     */
    private final Long patientId;

    /**
     * 
     * @param patientId Jedinsveni identifikator pacijenta po kome se vrši filtriranje
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
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
