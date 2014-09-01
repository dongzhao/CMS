package com.dzhao.simplecms.server.repository.inject;


import com.dzhao.simplecms.server.repository.spi.RepositoryModulePlugin;
import com.google.inject.AbstractModule;

import java.util.ServiceLoader;

public class RepositoryServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        ServiceLoader<RepositoryModulePlugin> modulePlugins = ServiceLoader.load(RepositoryModulePlugin.class);
        if(modulePlugins != null){
            for (RepositoryModulePlugin modulePlugin : modulePlugins){
                install(modulePlugin);
            }
        }
    }
}
