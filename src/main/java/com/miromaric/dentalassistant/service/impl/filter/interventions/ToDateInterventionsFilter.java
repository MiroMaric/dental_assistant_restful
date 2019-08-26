package com.miromaric.dentalassistant.service.impl.filter.interventions;

import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.service.impl.filter.FilterHandler;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Implementrira filter za filtriranje liste intervencija. Odbacuju se sve
 * intervencije koje su zakazane posle navedenog datuma.
 *
 * @author Miro Marić
 */
public final class ToDateInterventionsFilter extends FilterHandler<Intervention> {

    /**
     * Datum posle kojeg se odbacuju izvršene intervencije.
     */
    private final Date date;

    /**
     *
     * @param date Datum posle kojeg se odbacuju izvršene intervencije
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
    public ToDateInterventionsFilter(Date date, FilterHandler successor) {
        super(successor);
        this.date = date;
    }

    @Override
    protected List<Intervention> concreteFilter(List<Intervention> interventions) {
        if (date != null) {
            for (Iterator<Intervention> iter = interventions.listIterator(); iter.hasNext();) {
                if (iter.next().getDate().getTime() > date.getTime()) {
                    iter.remove();
                }
            }
        }
        return interventions;
    }

}
