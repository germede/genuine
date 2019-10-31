package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.DefaultConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.PropertiesConfigurationService;
import org.fluentness.service.localization.PropertiesLocalizationService;
import org.fluentness.service.logger.JulLoggerService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.routing.DefaultRoutingService;
import org.fluentness.service.server.TomcatServerService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public interface Application {

    static  <T> List<Class<? extends T>> loadClasses(String packageName, Class<T> parent) throws AutoLoaderException {
        List<Class<? extends T>> result = new LinkedList<>();
        try {
            String path = packageName.replace(".", "/");
            URL root = Thread.currentThread().getContextClassLoader().getResource(path);

            // filter .class files in project directory
            if (root != null) {
                File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));
                if (files != null) {
                    for (File file : files) {
                        String className = file.getName().replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(packageName + "." + className);
                        // find classes implementing parent
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

            // filter .class files in jar file
            String jarPath = new File(Fluentness.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            if (jarPath.endsWith(".jar")) {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().startsWith(path)) {
                        String className = entry.getName().replace('/', '.').replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(className);
                        // find classes implementing parent
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | IOException | URISyntaxException e) {
            throw new AutoLoaderException(e);
        }
        return result;
    }

    default List<Class<? extends Service>> getServices() throws AutoLoaderException {
        List<Class<? extends Service>> sClasses = loadClasses(this.getClass().getPackage().getName() + ".service", Service.class);
        sClasses.add(PropertiesConfigurationService.class);
        sClasses.add(PropertiesLocalizationService.class);
        sClasses.add(JulLoggerService.class);
        sClasses.add(OpenJpaPersistenceService.class);
        sClasses.add(DefaultRoutingService.class);
        sClasses.add(TomcatServerService.class);
        return sClasses;
    }

    default List<Class<? extends Repository>> getRepositories() throws AutoLoaderException {
        return loadClasses(this.getClass().getPackage().getName() + ".repository", Repository.class);
    }

    default List<Class<? extends Controller>> getControllers() throws AutoLoaderException {
        List<Class<? extends Controller>> cClasses = loadClasses(this.getClass().getPackage().getName() + ".controller", Controller.class);
        cClasses.add(DefaultConsoleController.class);
        return cClasses;
    }

    class AutoLoaderException extends Exception {
        AutoLoaderException(java.lang.Exception exception) {
            super(exception);
        }
    }
}
