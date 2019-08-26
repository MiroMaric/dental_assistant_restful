
package com.miromaric.dentalassistant.service.impl.filter;

import java.util.List;


public abstract class FilterHandler<ResourceType> {
    
    protected final FilterHandler successor;

    public FilterHandler(FilterHandler successor) {
        this.successor = successor;
    }
    
    public List<ResourceType> filter(List<ResourceType> resources){
        if(resources==null){
            throw new RuntimeException("Resources cannot be null");
        }
        List<ResourceType> filteredResources = concreteFilter(resources);
        return successor==null?filteredResources:successor.filter(filteredResources);
    }
    
    protected abstract List<ResourceType> concreteFilter(List<ResourceType> resources);
    
    
    
}
