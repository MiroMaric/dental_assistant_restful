package com.miromaric.dentalassistant.service;

import java.util.List;

/**
 *
 * @author MikoPC
 * @param <ResourceType>
 * @param <KeyType>
 */
public interface Service<ResourceType,KeyType>{
    
    void save(ResourceType resource);
    List<ResourceType> getAll();
    ResourceType getOne(KeyType id);
    ResourceType update(KeyType id,ResourceType resource);
    ResourceType remove(KeyType id);
    
}
