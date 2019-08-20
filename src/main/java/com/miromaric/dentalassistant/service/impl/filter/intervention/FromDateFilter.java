package com.miromaric.dentalassistant.service.impl.filter.intervention;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FromDateFilter extends FilterHandler<Intervention> {

    private final Date date;

    public FromDateFilter(Date date, FilterHandler successor) {
        super(successor);
        this.date = date;
    }

    @Override
    public List<Intervention> handleRequest(List<Intervention> interventions) {
        if (interventions == null) {
            throw new RuntimeException("Interventions cannot be null");
        }
        if (date != null) {
            for(Iterator<Intervention> iter = interventions.listIterator();iter.hasNext();){
                if(iter.next().getDate().getTime() < date.getTime())
                    iter.remove();
            }
        }
        System.out.println(interventions.size());
        return successor == null ? interventions : successor.handleRequest(interventions);
    }
}
