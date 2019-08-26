package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;

public final class DentistInterventionsFilter extends FilterHandler<Intervention> {

    private final String username;

    public DentistInterventionsFilter(String username, FilterHandler successor) {
        super(successor);
        this.username = username;
    }

    @Override
    protected List<Intervention> concreteFilter(List<Intervention> interventions) {
        if(username!=null){
            for(Iterator<Intervention> iter = interventions.listIterator();iter.hasNext();){
                if(!iter.next().getUser().getUsername().equals(this.username)){
                    iter.remove();
                }
            }
        }
        return interventions;
    }

}
