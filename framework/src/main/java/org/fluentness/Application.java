package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.dependency.ClassLoadingException;
import org.fluentness.service.dependency.DependencyService;

import java.util.List;

public interface Application {

    // todo make one scanner service for loading classes
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
