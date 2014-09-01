package com.dzhao.simplecms.server.repository.database.dao;


import com.dzhao.simplecms.server.repository.database.dao.inject.DaoModule;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class JpaDaoTestModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DaoModule());
    }

    @Provides
    @Named("persistenceUnit")
    String providePersistenceUnitName(){
        return "unit-test";
    }
}
