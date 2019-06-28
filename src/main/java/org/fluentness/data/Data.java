package org.fluentness.data;

import org.fluentness.base.Settings;
import org.fluentness.base.Structure;
import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.fluentness.base.constants.SettingKeys.*;

public enum Data {
    call;

    private SessionFactory sessionFactory;

    public void initialize(String appPackage) throws FluentnessInitializationException {

        if (Settings.call.is(ENABLE_HIBERNATE)) {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.url",
                "jdbc:" + Settings.call.get(HIBERNATE_DRIVER) +
                    "://" + Settings.call.get(HIBERNATE_HOST) +
                    ":" + Settings.call.get(HIBERNATE_PORT) +
                    "/" + Settings.call.get(Key.HIBERNATE_DATABASE) +
                    Settings.call.get(HIBERNATE_PARAMS));
            configuration.setProperty("hibernate.connection.driver_class", Settings.call.get(HIBERNATE_DRIVER_CLASS));
            configuration.setProperty("hibernate.dialect", Settings.call.get(HIBERNATE_DIALECT));
            configuration.setProperty("hibernate.connection.username", Settings.call.get(HIBERNATE_USERNAME));
            configuration.setProperty("hibernate.connection.password", Settings.call.get(HIBERNATE_PASSWORD));

            for (String hibernateOption : Settings.call.get(HIBERNATE_OPTIONS).split(";")) {
                String[] keyValue = hibernateOption.split(":");
                configuration.setProperty(keyValue[0],keyValue[1]);
            }

            for (Class<? extends Model> modelClass : getModelClasses(appPackage)) {
                configuration.addAnnotatedClass(modelClass);
            }

            sessionFactory = configuration.buildSessionFactory();
        }
    }

    private List<Class<? extends Model>> getModelClasses(String appPackage) throws FluentnessInitializationException {
        List<Class<? extends Model>> result = new ArrayList<>();
        try {

            String packageName = appPackage + Structure.call.data;
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
                        if (Model.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<? extends Model>) clazz);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            throw new FluentnessInitializationException(e);
        }
        return result;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}
