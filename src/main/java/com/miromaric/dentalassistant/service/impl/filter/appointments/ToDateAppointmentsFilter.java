package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * Implementrira filter za filtriranje liste zakazanih termina.
 * Odbacuju se svi zakazani termini koji su zakazani posle navedenog datuma.
 * @author Miro Marić
 * @see Appointment
 */
public final class ToDateAppointmentsFilter extends FilterHandler<Appointment> {

    /**
     * Datum posle kojeg se odbacuju zakazani termini.
     */
    private final Date date;

    /**
     * 
     * @param date Datum posle kojeg se odbacuju zakazani termini
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
    public ToDateAppointmentsFilter(Date date, FilterHandler successor) {
        super(successor);
        this.date = date;
    }

    @Override
    protected List<Appointment> concreteFilter(List<Appointment> appointments) {
        if (date != null) {
            for (Iterator<Appointment> iter = appointments.listIterator(); iter.hasNext();) {
                if(iter.next().getStartTime().getTime() > date.getTime() ){
                    iter.remove();
                }
            }
        }
        return appointments;
    }

}
