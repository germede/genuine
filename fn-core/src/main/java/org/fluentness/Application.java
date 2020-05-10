package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.DefaultConfiguration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.translator.DefaultTranslator;

public interface Application {

    Setting<String> NAME = new Setting<>("Fluentness application");

    default void configure(Configuration configuration) {

    }

    default Provider<Controller> controllers() {
        return new Provider<Controller>()
            .add(DefaultConsoleController.class);
    }

    default Provider<Repository> repositories() {
        return new Provider<>();
    }

    default Provider<Service> services() {
        return new Provider<Service>()
            .add(DefaultConfiguration.class)
            .add(JulLog.class)
            .add(FilePersistence.class)
            .add(DefaultTranslator.class)
            ;
    }

    void run(String[] args) throws Exception;
}
