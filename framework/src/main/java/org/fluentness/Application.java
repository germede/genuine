package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.FluentnessController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configurator.DefaultConfigurator;
import org.fluentness.service.configurator.Setting;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.mailer.SocketMailer;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.server.SunServer;
import org.fluentness.service.translator.DefaultTranslator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public interface Application {

    Setting<String> NAME = new Setting<>("Fluentness application");

    default List<Class<? extends Service>> getServices() {
        return load(Service.class,
            JulLogger.class,
            SocketMailer.class,
            JdbcPersistence.class,
            SunServer.class,
            DefaultConfigurator.class,
            DefaultTranslator.class,
            BasicAuthenticator.class
        );
    }

    default List<Class<? extends Repository>> getRepositories() {
        return load(Repository.class);
    }

    default List<Class<? extends Controller>> getControllers() {
        return load(Controller.class,
            FluentnessController.class
        );
    }

    default <T> List<Class<? extends T>> load(Class<T> parent, Class<? extends T>... extra) {
        List<Class<? extends T>> result = new LinkedList<>();
        // base package name is same as application's one (convention)
        String packageName = getClass().getPackage().getName() + "." + parent.getSimpleName().toLowerCase();
        try {
            // look for classes when not using jar file
            URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
            if (root != null) {
                File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));
                if (files != null) {
                    for (File file : files) {
                        String className = file.getName().replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(packageName + "." + className);
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

            // look for classes when using jar file
            String jarPath = new File(Fluentness.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            if (jarPath.endsWith(".jar")) {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().startsWith(packageName.replace(".", "/"))) {
                        String className = entry.getName().replace('/', '.').replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(className);
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        result.addAll(Arrays.asList(extra));
        return result;
    }

}
