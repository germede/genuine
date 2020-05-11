package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configurator;
import org.fluentness.service.injection.Provider;

public interface Application {

    // todo make provider method safer using no return type for all providers
//    default Provider controllers(Class<? extends C>... controllers) {
//        return new Provider<C>()
//            .add((Class<? extends C>) DefaultConsoleController.class);
//    }
//
//    static Provider<V> views() {
//        return new Provider<>();
//    }
//
//    static Provider<R> repositories() {
//        return new Provider<>();
//    }
//
//    static Provider<S> services() {
//        return new Provider<Service>()
//            .add(DefaultConfiguration.class)
//            .add(JulLog.class)
//            .add(DefaultTranslator.class)
//            ;
//    }

    Provider<? extends Service> getServices();
    Provider<Repository> getRepositories();
    Provider<Controller> getControllers();
    Configurator getConfigurator();

    void run(String[] args) throws Exception;
}
