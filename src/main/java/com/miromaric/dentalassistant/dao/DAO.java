package com.miromaric.dentalassistant.dao;

import java.util.List;

/**
 *
 * @author MikoPC
 * @param <ResourceType>
 * @param <KeyType>
 */

public interface DAO<ResourceType,KeyType>{
    
    boolean save(ResourceType resource);
    List<ResourceType> getAll();
    ResourceType getOne(KeyType key);
    ResourceType update(KeyType key,ResourceType resource);
    ResourceType remove(KeyType key);
    
}
