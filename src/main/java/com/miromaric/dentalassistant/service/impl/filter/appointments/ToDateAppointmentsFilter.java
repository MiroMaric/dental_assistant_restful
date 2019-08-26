package com.miromaric.dentalassistant.service.impl.filter.appointments;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ToDateAppointmentsFilter extends FilterHandler<Appointment> {

    private final Date date;

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
