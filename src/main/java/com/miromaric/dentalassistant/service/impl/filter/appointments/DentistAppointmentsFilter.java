package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;
/**
 * Implementrira filter za filtriranje liste zakazanih termina.
 * Filtriranje se vrši po korisničkom imenu doktora.
 * @author Miro Marić
 * @see Appointment
 */
public final class DentistAppointmentsFilter extends FilterHandler<Appointment>{

    /**
     * Korisničko ime doktora.
     */
    private final String username;

    /**
     * @param username Korisničko ime doktora
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
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
