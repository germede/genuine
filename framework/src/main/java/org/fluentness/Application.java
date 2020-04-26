package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Application {

    Setting<String> NAME = new Setting<>("Fluentness application");

    Class<? extends Service>[] getServices();

    Class<? extends Repository>[] getRepositories();

    Class<? extends Controller>[] getControllers();

    default Class<? extends Service>[] services(Class<? extends Service>... services) {
        return services;
    }

    default Class<? extends Repository>[] repositories(Class<? extends Repository>... repositories) {
        return repositories;
    }

    default Class<? extends Controller>[] controllers(Class<? extends Controller>... controllers) {
        return controllers;
    }

}
