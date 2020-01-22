package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.MapConfiguration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.mailer.Mailer;
import org.fluentness.service.mailer.SocketMailer;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;
import org.fluentness.service.translator.SimpleTranslator;
import org.fluentness.service.translator.Translator;

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

    Setting<String> NAME = new Setting<>("Fluentness application");

    default <T> Class<? extends T>[] load(Class<T> parent, Class<? extends T>... extra) {
        List<Class<? extends T>> result = new LinkedList<>();
        String packageName = getClass().getPackage().getName() + "." + parent.getSimpleName().toLowerCase();

        try {
            // directory
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

            // jar file
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
        return result.toArray(new Class[0]);
    }


    default Class<? extends Controller>[] getControllers() {
        return load(Controller.class);
    }

    default Class<? extends Repository>[] getRepositories() {
        return load(Repository.class);
    }

    default Class<? extends Service>[] getServices() {
        return load(Service.class);
    }


    default Class<? extends Configuration> getConfiguration() {
        return MapConfiguration.class;
    }

    default Class<? extends Logger> getLogger() {
        // doesn't apply to mobile
        return JulLogger.class;
    }

    default Class<? extends Mailer> getMailer() {
        return SocketMailer.class;
    }

    default Class<? extends Persistence> getPersistence() {
        return JdbcPersistence.class;
    }

    default Class<? extends Translator> getTranslator() {
        return SimpleTranslator.class;
    }

    default Class<? extends Server> getServer() {
        return SunServer.class;
    }

    void configure(Configuration configuration);
}
