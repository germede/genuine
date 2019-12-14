package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.cache.MemoryCache;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.configurator.FnConfigurator;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.loader.LoaderException;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.mailer.SocketMailer;
import org.fluentness.service.persistence.SqlPersistence;
import org.fluentness.service.server.SunServer;

import java.util.List;

public interface Application {
    enum Platform {
        CONSOLE,
        DESKTOP,
        MOBILE,
        WEB;
    }

    enum Environment {
        DEV,
        TEST,
        STAGE,
        PROD;
    }

    void configure(Configurator configurator);

    default String getName() {
        return this.getClass().getSimpleName().replace("Application", "");
    }

    default Platform getPlatform() {
        return Platform.WEB;
    }

    default Environment getEnvironment() {
        return Environment.DEV;
    }

    default List<Class<? extends Controller>> getControllers(Loader loader) throws LoaderException {
        List<Class<? extends Controller>> controllers = loader.load(this.getClass().getPackage().getName() + ".controller", Controller.class);
        controllers.add(DefaultConsoleController.class);
        return controllers;
    }

    default List<Class<? extends Repository>> getRepositories(Loader loader) throws LoaderException {
        return loader.load(this.getClass().getPackage().getName() + ".repository", Repository.class);
    }

    default List<Class<? extends Service>> getServices(Loader loader) throws LoaderException {
        List<Class<? extends Service>> services = loader.load(this.getClass().getPackage().getName() + ".service", Service.class);
        services.add(FnConfigurator.class);
        services.add(JulLogger.class);
        services.add(SocketMailer.class);
        services.add(SqlPersistence.class);
        if (getPlatform().equals(Application.Platform.WEB)) {
            services.add(MemoryCache.class);
            services.add(BasicAuthenticator.class);
            services.add(SunServer.class);
        }
        return services;
    }
}
