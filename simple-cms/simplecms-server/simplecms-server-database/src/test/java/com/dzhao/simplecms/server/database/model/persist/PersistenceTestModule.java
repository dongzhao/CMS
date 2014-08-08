package com.dzhao.simplecms.server.database.model.persist;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceTestModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    EntityManagerFactory provideEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("unit-test");
    }
}
