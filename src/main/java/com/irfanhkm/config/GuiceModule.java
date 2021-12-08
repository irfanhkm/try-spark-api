package com.irfanhkm.config;

import com.google.code.guice.repository.configuration.ScanningJpaRepositoryModule;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

    private final String persistenceUnitName;
    private final String repositoriesBasePackageName;

    public GuiceModule(String persistenceUnitName, String repositoriesBasePackageName) {
        this.persistenceUnitName = persistenceUnitName;
        this.repositoriesBasePackageName = repositoriesBasePackageName;
    }

    @Override
    protected void configure() {
        // Repository classes auto-scanned by package name
        install(new ScanningJpaRepositoryModule(repositoriesBasePackageName, persistenceUnitName));
    }

}
