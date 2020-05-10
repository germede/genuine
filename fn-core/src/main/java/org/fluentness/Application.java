package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.DefaultConfiguration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.translator.DefaultTranslator;
import org.fluentness.view.View;

public interface Application {

    // todo make provider method safer using no return type for all providers
    default Provider<Controller> controllers() {
        return new Provider<Controller>()
            .add(DefaultConsoleController.class);
    }

    default Provider<View> views() {
        return new Provider<>();
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

    default void configure(Configuration configuration) {

    }


    void run(String[] args) throws Exception;
}
