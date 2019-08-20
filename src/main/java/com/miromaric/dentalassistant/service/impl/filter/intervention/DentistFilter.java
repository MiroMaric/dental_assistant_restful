package com.miromaric.dentalassistant.service.impl.filter.intervention;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;

public class DentistFilter extends FilterHandler<Intervention> {

    private final String username;

    public DentistFilter(String username, FilterHandler successor) {
        super(successor);
        this.username = username;
    }

    @Override
    public List<Intervention> handleRequest(List<Intervention> interventions) {
        if(interventions==null){
            throw new RuntimeException("Interventions cannot be null");
        }
        if(username!=null){
            for(Iterator<Intervention> iter = interventions.listIterator();iter.hasNext();){
                if(!iter.next().getUser().getUsername().equals(this.username)){
                    iter.remove();
                }
            }
        }
        return successor==null?interventions:successor.handleRequest(interventions);
    }

}
