package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.XmlConfigurationService;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.dependency.ClassLoadingException;
import org.fluentness.service.dependency.InjectionException;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.router.DefaultRouterService;
import org.fluentness.service.server.TomcatServerService;
import org.fluentness.service.translator.XmlTranslatorService;

import java.util.List;

public interface Application {

    default void injectServices(DependencyService dependencyService) throws ClassLoadingException, InjectionException {
        List<Class<? extends Service>> services = dependencyService.loadClasses(
            this.getClass().getPackage().getName() + ".service", Service.class
        );
        services.add(XmlConfigurationService.class);
        services.add(XmlTranslatorService.class);
        services.add(JulLogger.class);
        services.add(OpenJpaPersistenceService.class);
        services.add(DefaultRouterService.class);
        services.add(TomcatServerService.class);
        dependencyService.inject(services);
    }

    default void injectRepositories(DependencyService dependencyService) throws ClassLoadingException, InjectionException {
        dependencyService.inject(
            dependencyService.loadClasses(
                this.getClass().getPackage().getName() + ".repository", Repository.class
            )
        );
    }

    default void injectControllers(DependencyService dependencyService) throws ClassLoadingException, InjectionException {
        List<Class<? extends Controller>> controllers = dependencyService.loadClasses(
            this.getClass().getPackage().getName() + ".controller", Controller.class
        );
        controllers.add(DefaultConsoleController.class);
        dependencyService.inject(controllers);
    }

}
