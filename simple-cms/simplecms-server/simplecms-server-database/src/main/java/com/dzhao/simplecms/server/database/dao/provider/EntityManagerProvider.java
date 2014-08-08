package com.dzhao.simplecms.server.database.dao.provider;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider implements Provider<EntityManager> {

    private static EntityManagerFactory emf = null;
    private final String persistenceUnitName;

    @Inject
    public EntityManagerProvider(@Named("persistenceUnit") String persistenceUnitName){
        this.persistenceUnitName = persistenceUnitName;
    }

    @Override
    /**
     * To return thread-safe entity manager
     */
    public EntityManager get() {
        if(emf==null)
            this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf.createEntityManager();
    }
}
