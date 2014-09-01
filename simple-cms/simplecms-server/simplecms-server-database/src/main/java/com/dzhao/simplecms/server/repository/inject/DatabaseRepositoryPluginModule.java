package com.dzhao.simplecms.server.repository.inject;


import com.dzhao.simplecms.server.repository.DatabaseRepositoryService;
import com.dzhao.simplecms.server.repository.RepositoryService;
import com.dzhao.simplecms.server.repository.database.dao.inject.DaoModule;
import com.dzhao.simplecms.server.repository.spi.RepositoryModulePlugin;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class DatabaseRepositoryPluginModule extends AbstractModule implements RepositoryModulePlugin {
    @Override
    protected void configure() {
        install(new DaoModule());

        Multibinder<RepositoryService> multibinder = Multibinder.newSetBinder(binder(), RepositoryService.class);
        multibinder.addBinding().to(DatabaseRepositoryService.class);
    }
}
