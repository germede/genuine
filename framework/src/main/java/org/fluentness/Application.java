package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.XmlConfiguration;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.manager.ClassLoadingException;
import org.fluentness.service.manager.InjectionException;
import org.fluentness.service.manager.Manager;
import org.fluentness.service.persistence.OpenJpaPersistence;
import org.fluentness.service.router.DefaultRouter;
import org.fluentness.service.server.TomcatServer;
import org.fluentness.service.translator.XmlTranslator;

import java.util.List;

public interface Application {

    default void injectServices(Manager manager) throws ClassLoadingException, InjectionException {
        List<Class<? extends Service>> services = manager.loadClasses(
            this.getClass().getPackage().getName() + ".service", Service.class
        );
        services.add(XmlConfiguration.class);
        services.add(XmlTranslator.class);
        services.add(JulLogger.class);
        services.add(OpenJpaPersistence.class);
        services.add(DefaultRouter.class);
        services.add(TomcatServer.class);
        manager.inject(services);
    }

    default void injectRepositories(Manager manager) throws ClassLoadingException, InjectionException {
        manager.inject(
            manager.loadClasses(
                this.getClass().getPackage().getName() + ".repository", Repository.class
            )
        );
    }

    default void injectControllers(Manager manager) throws ClassLoadingException, InjectionException {
        List<Class<? extends Controller>> controllers = manager.loadClasses(
            this.getClass().getPackage().getName() + ".controller", Controller.class
        );
        controllers.add(DefaultConsoleController.class);
        manager.inject(controllers);
    }

}
