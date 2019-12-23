package org.fluentness;

import org.fluentness.configuration.Configuration;
import org.fluentness.configuration.MapConfiguration;
import org.fluentness.controller.Controller;
import org.fluentness.injector.ConstructorInjector;
import org.fluentness.injector.Injector;
import org.fluentness.logger.AndroidLogger;
import org.fluentness.logger.JulLogger;
import org.fluentness.logger.Logger;
import org.fluentness.mailer.Mailer;
import org.fluentness.mailer.SocketMailer;
import org.fluentness.model.Model;
import org.fluentness.persistence.Persistence;
import org.fluentness.persistence.SqlPersistence;
import org.fluentness.server.Server;
import org.fluentness.server.SunServer;
import org.fluentness.view.View;

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

    default <T> Class<? extends T>[] load(Class<T> parent) {
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

    default String getName() {
        return this.getClass().getSimpleName().replace("Application", "");
    }

    default Platform getPlatform() {
        return Platform.WEB;
    }

    default Class<? extends Configuration> getConfiguration() {
        return MapConfiguration.class;
    }

    default Class<? extends Controller>[] getControllers() {
        return load(Controller.class);
    }

    default Class<? extends Injector> getInjector() {
        return ConstructorInjector.class;
    }

    default Class<? extends Logger> getLogger() {
        return getPlatform().equals(Platform.MOBILE) ? AndroidLogger.class : JulLogger.class;
    }

    default Class<? extends Mailer> getMailer() {
        return SocketMailer.class;
    }

    default Class<? extends Model>[] getModels() {
        return load(Model.class);
    }

    default Class<? extends Persistence> getPersistence() {
        return SqlPersistence.class;
    }

    default Class<? extends Server> getServer() {
        return SunServer.class;
    }

    default Class<? extends View>[] getViews() {
        return load(View.class);
    }

    void configure(Configuration configuration);

    enum Platform {
        CONSOLE,
        DESKTOP,
        MOBILE,
        WEB
    }
}
