package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Iterator;
import java.util.List;
/**
 * Implementrira filter za filtriranje liste intervencija.
 * Filtriranje se vrši po korisničkom imenu doktora.
 * @author Miro Marić
 * @see Intervention
 */
public final class DentistInterventionsFilter extends FilterHandler<Intervention> {

    /**
     * Korisničko ime doktora.
     */
    private final String username;

    /**
     * @param username Korisničko ime doktora
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
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
