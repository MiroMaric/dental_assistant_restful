package com.miromaric.dentalassistant.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MikoPC
 */
public class MyPersistence {
    
    private static MyPersistence instance;
    private final EntityManagerFactory emf;
    
    private MyPersistence() {
        emf = Persistence.createEntityManagerFactory("HerokuDentalAssistantPU");
    }
    
    public static MyPersistence getInstance(){
        if(instance==null)
            instance = new MyPersistence();
        return instance;
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    
    
    
}
