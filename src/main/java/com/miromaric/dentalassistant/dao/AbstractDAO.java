package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.persistence.MyPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author MikoPC
 * @param <ResourceType>
 * @param <KeyType>
 */
public abstract class AbstractDAO<ResourceType, KeyType> implements DAO<ResourceType, KeyType> {

    protected EntityManagerFactory emf;

    public AbstractDAO() {
        emf = MyPersistence.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean save(ResourceType resource) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ResourceType dbResource = findExistingResource(resource, em);
            if (dbResource == null) {
                em.persist(resource);
                //em.getTransaction().commit();
            }
            em.getTransaction().commit();
            return dbResource == null;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public ResourceType getOne(KeyType key) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ResourceType resource = findResourceById(key, em);
            em.getTransaction().commit();
            return resource;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ResourceType> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<ResourceType> resources = findAllResources(em);
            em.getTransaction().commit();
            return resources;

        } finally {
            em.close();
        }
    }

    @Override
    public ResourceType update(KeyType key, ResourceType resource) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ResourceType uResource = findResourceById(key, em);
            if (uResource != null) {
                setIdToResource(resource, key);
                em.merge(resource);
                //em.getTransaction().commit();
            }
            em.getTransaction().commit();
            return uResource;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public ResourceType remove(KeyType key) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ResourceType resource = findResourceById(key, em);
            if (resource != null) {
                em.remove(resource);
                //em.getTransaction().commit();
            }
            em.getTransaction().commit();
            return resource;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    protected abstract ResourceType findExistingResource(ResourceType resource, EntityManager em);

    protected abstract List<ResourceType> findAllResources(EntityManager em);

    protected abstract ResourceType findResourceById(KeyType id, EntityManager em);

    protected abstract void setIdToResource(ResourceType resource, KeyType key);

}
