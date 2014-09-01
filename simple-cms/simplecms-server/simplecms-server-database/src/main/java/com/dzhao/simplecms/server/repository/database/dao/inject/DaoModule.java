package com.dzhao.simplecms.server.repository.database.dao.inject;


import com.dzhao.simplecms.server.repository.database.dao.JpaDao;
import com.dzhao.simplecms.server.repository.database.dao.api.Dao;
import com.dzhao.simplecms.server.repository.database.dao.provider.EntityManagerProvider;
import com.dzhao.simplecms.server.repository.database.model.DbFile;
import com.dzhao.simplecms.server.repository.database.model.DbFileContent;
import com.dzhao.simplecms.server.repository.database.model.DbFolder;
import com.google.inject.*;

import javax.persistence.EntityManager;

public class DaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EntityManager.class).toProvider(EntityManagerProvider.class).in(Singleton.class);
        //bind(Dao.class).to(JpaDao.class).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<DbFolder, String>>(){}).to(new TypeLiteral<JpaDao<DbFolder, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<DbFile, String>>(){}).to(new TypeLiteral<JpaDao<DbFile, String>>(){}).in(Scopes.SINGLETON);
        bind(new TypeLiteral<Dao<DbFileContent, String>>(){}).to(new TypeLiteral<JpaDao<DbFileContent, String>>(){}).in(Scopes.SINGLETON);
    }
}
