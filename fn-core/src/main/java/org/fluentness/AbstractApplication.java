package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configurator;
import org.fluentness.service.injection.Provider;

public abstract class AbstractApplication<S extends Service, R extends Repository, C extends Controller> implements Application {

    private final Provider<S> services;
    private final Provider<R> repositories;
    private final Provider<C> controllers;
    private final Configurator configurator;

    public AbstractApplication(Provider<S> services,
                               Provider<R> repositories,
                               Provider<C> controllers,
                               Configurator configurator) {

        this.services = services;
        this.repositories = repositories;
        this.controllers = controllers;
        this.configurator = configurator;
    }


    protected static <E extends Service> Provider<? extends E> services(Class<? extends E>... services) {
        return new Provider<>((Class<E>[]) services);
    }


}
