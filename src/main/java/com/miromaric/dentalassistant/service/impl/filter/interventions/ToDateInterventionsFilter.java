package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ToDateInterventionsFilter extends FilterHandler<Intervention> {

    private final Date date;

    public ToDateInterventionsFilter(Date date, FilterHandler successor) {
        super(successor);
        this.date = date;
    }

    @Override
    protected List<Intervention> concreteFilter(List<Intervention> interventions) {
        if (date != null) {
            for(Iterator<Intervention> iter = interventions.listIterator();iter.hasNext();){
                if(iter.next().getDate().getTime() > date.getTime())
                    iter.remove();
            }
        }
        return interventions;
    }

}
