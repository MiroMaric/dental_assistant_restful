
package com.miromaric.dentalassistant.service.impl.filter;

import java.util.List;

/**
 * Definiše interfejs za filtriranje liste resursa.
 * Sadrži link ka sledećem filter objektu.
 * @author Miro Marić
 * @param <ResourceType> Tip resursa koji se filtrira
 *
 */
public abstract class FilterHandler<ResourceType> {
    
    /**
     * Sledeći filter objekat u lancu povezanih filtera.
     */
    protected final FilterHandler successor;

    /**
     * 
     * @param successor Sledeći filter objekat u lancu povezanih filtera
     */
    public FilterHandler(FilterHandler successor) {
        this.successor = successor;
    }
    
    /**
     * Skelet algoritma za filtriranje liste objekata.
     * @param resources Lista objekata koju je potrebno isfiltrirati
     * @throws java.lang.RuntimeException Ako je lista objekata koju je potrebno isfiltrirati jednaka null
     * @return Isfiltrirana lista objekata
     */
    public List<ResourceType> filter(List<ResourceType> resources){
        if(resources==null){
            throw new RuntimeException("Resources cannot be null");
        }
        List<ResourceType> filteredResources = concreteFilter(resources);
        return successor==null?filteredResources:successor.filter(filteredResources);
    }
    
    /**
     * Konkretna implementacija filtera.
     * @param resources Lista objekata koju je potrebno isfiltrirati
     * @return Isfiltrirana lista objekata
     */
    protected abstract List<ResourceType> concreteFilter(List<ResourceType> resources);
    
    
    
}
