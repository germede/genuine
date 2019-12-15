package org.fluentness;

import org.fluentness.authenticator.Authenticator;
import org.fluentness.configuration.Configuration;
import org.fluentness.controller.Controller;
import org.fluentness.injector.FnInjector;
import org.fluentness.injector.Injector;
import org.fluentness.localization.AbstractStringLocalization;
import org.fluentness.logger.AndroidLogger;
import org.fluentness.logger.JulLogger;
import org.fluentness.logger.Logger;
import org.fluentness.mailer.Mailer;
import org.fluentness.mailer.SocketMailer;
import org.fluentness.model.Model;
import org.fluentness.persistence.Persistence;
import org.fluentness.persistence.SqlPersistence;
import org.fluentness.repository.Repository;
import org.fluentness.server.Server;
import org.fluentness.server.SunServer;
import org.fluentness.style.Style;
import org.fluentness.validator.Validator;
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

    static <T> List<Class<? extends T>> load(String packageName, Class<T> parent) {
        List<Class<? extends T>> result = new LinkedList<>();
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
        return result;
    }

    default String getName() {
        return this.getClass().getSimpleName().replace("Application", "");
    }

    default Platform getPlatform() {
        return Platform.WEB;
    }

    default Environment getEnvironment() {
        return Environment.DEV;
    }

    default List<Class<? extends Authenticator>> getAuthenticator() {
        return load(
                getClass().getPackage().getName() + "." + Authenticator.class.getSimpleName().toLowerCase(),
                Authenticator.class
        );
    }

    default Class<? extends Configuration> getConfiguration() {
        try {
            return (Class<? extends Configuration>) Class.forName(
                    // package
                    getClass().getPackage().getName() + "." + Configuration.class.getSimpleName().toLowerCase() +
                    // className
                    getEnvironment().toString() + Configuration.class.getSimpleName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    default List<Class<? extends Controller>> getControllers() {
        return load(
                getClass().getPackage().getName() + "." + Controller.class.getSimpleName().toLowerCase(),
                Controller.class
        );
    }

    default Class<? extends Injector> getInjector() {
        return FnInjector.class;
    }

    default List<Class<? extends AbstractStringLocalization>> getLocalizations() {
        return load(
                getClass().getPackage().getName() + "." + AbstractStringLocalization.class.getSimpleName().toLowerCase(),
                AbstractStringLocalization.class
        );
    }

    default Class<? extends Logger> getLogger() {
        if (getPlatform().equals(Platform.MOBILE)) {
            return AndroidLogger.class;
        }
        return JulLogger.class;
    }

    default Class<? extends Mailer> getMailer() {
        return SocketMailer.class;
    }

    default List<Class<? extends Model>> getModels() {
        return load(
                getClass().getPackage().getName() + "." + Model.class.getSimpleName().toLowerCase(),
                Model.class
        );
    }

    default Class<? extends Persistence> getPersistence() {
        return SqlPersistence.class;
    }

    default List<Class<? extends Repository<Model>>> getRepositories() {
        return load(
                getClass().getPackage().getName() + "." + Repository.class.getSimpleName().toLowerCase(),
                Repository.class
        );
    }

    default Class<? extends Server> getServer() {
        return SunServer.class;
    }

    default List<Class<? extends Style>> getStyles() {
        return load(
                getClass().getPackage().getName() + "." + Style.class.getSimpleName().toLowerCase(),
                Style.class
        );
    }

    default List<Class<? extends Validator>> getValidators() {
        return load(
                getClass().getPackage().getName() + "." + Validator.class.getSimpleName().toLowerCase(),
                Validator.class
        );
    }

    default List<Class<? extends View>> getViews() {
        return load(
                getClass().getPackage().getName() + "." + View.class.getSimpleName().toLowerCase(),
                View.class
        );
    }


    enum Platform {
        CONSOLE,
        DESKTOP,
        MOBILE,
        WEB
    }

    enum Environment {
        DEV,
        TEST,
        STAGE,
        PROD;

        @Override
        public String toString() {
            String toString = super.toString();
            return toString.substring(0, 1).toUpperCase() + toString.substring(1);
        }
    }
}
