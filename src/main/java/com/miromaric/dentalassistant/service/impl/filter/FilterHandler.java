
package com.miromaric.dentalassistant.service.impl.filter;

import java.util.List;


public abstract class FilterHandler<ResourceType> {
    
    protected final FilterHandler successor;

    public FilterHandler(FilterHandler successor) {
        this.successor = successor;
    }
    
    public abstract List<ResourceType> handleRequest(List<ResourceType> resources);
    
}
