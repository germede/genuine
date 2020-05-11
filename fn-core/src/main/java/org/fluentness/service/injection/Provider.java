package org.fluentness.service.injection;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Provider {

    private final List<Class<? extends Service>> services = new LinkedList<>();
    private final List<Class<? extends Repository>> repositories = new LinkedList<>();
    private final List<Class<? extends Controller>> controllers = new LinkedList<>();

    public Provider service(Class<? extends Service> service) {
        services.add(service);
        return this;
    }

    public Provider repository(Class<? extends Repository> repository) {
        repositories.add(repository);
        return this;
    }

    public Provider controller(Class<? extends Controller> controller) {
        controllers.add(controller);
        return this;
    }

    List<Class<? extends Service>> getServices() {
        Collections.reverse(services);
        return services;
    }

    List<Class<? extends Repository>> getRepositories() {
        Collections.reverse(repositories);
        return repositories;
    }

    List<Class<? extends Controller>> getControllers() {
        Collections.reverse(controllers);
        return controllers;
    }
}
