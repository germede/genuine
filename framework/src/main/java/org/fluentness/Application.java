package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.XmlConfigurationService;
import org.fluentness.service.dependency.ClassLoadingException;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.dependency.InjectionException;
import org.fluentness.service.logger.JulLoggerService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.router.DefaultRouterService;
import org.fluentness.service.server.TomcatServerService;
import org.fluentness.service.translator.XmlTranslatorService;

import java.util.List;

public interface Application {

    default List<Class<? extends Service>> getServices(DependencyService dependencyService) throws ClassLoadingException {
        return dependencyService.loadClasses(this.getClass().getPackage().getName() + ".service", Service.class);
    }

    default List<Class<? extends Repository>> getRepositories(DependencyService dependencyService) throws ClassLoadingException {
        return dependencyService.loadClasses(this.getClass().getPackage().getName() + ".repository", Repository.class);
    }

    default List<Class<? extends Controller>> getControllers(DependencyService dependencyService) throws ClassLoadingException {
        return dependencyService.loadClasses(this.getClass().getPackage().getName() + ".controller", Controller.class);
    }

}
