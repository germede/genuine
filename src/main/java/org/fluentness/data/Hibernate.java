package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.Settings;
import org.fluentness.common.constants.OnionArchitecture;
import org.fluentness.common.logging.Log;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.fluentness.common.constants.SettingKeys.*;

public enum Hibernate {
    INSTANCE;

    private org.hibernate.SessionFactory sessionFactory;

    public void initialize() {

        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url",
            "jdbc:" + Settings.INSTANCE.get(HIBERNATE_DRIVER) +
                "://" + Settings.INSTANCE.get(HIBERNATE_HOST) +
                ":" + Settings.INSTANCE.get(HIBERNATE_PORT) +
                "/" + Settings.INSTANCE.get(Key.HIBERNATE_DATABASE) +
                Settings.INSTANCE.get(HIBERNATE_PARAMS));
        configuration.setProperty("hibernate.connection.driver_class", Settings.INSTANCE.get(HIBERNATE_DRIVER_CLASS));
        configuration.setProperty("hibernate.dialect", Settings.INSTANCE.get(HIBERNATE_DIALECT));
        configuration.setProperty("hibernate.connection.username", Settings.INSTANCE.get(HIBERNATE_USERNAME));
        configuration.setProperty("hibernate.connection.password", Settings.INSTANCE.get(HIBERNATE_PASSWORD));

        for (String hibernateOption : Settings.INSTANCE.get(HIBERNATE_OPTIONS).split(";")) {
            String[] keyValue = hibernateOption.split(":");
            configuration.setProperty(keyValue[0],keyValue[1]);
        }

        for (Class<? extends Model> modelClass : getModelClasses()) {
            configuration.addAnnotatedClass(modelClass);
        }

        sessionFactory = configuration.buildSessionFactory();

    }

    private List<Class<? extends Model>> getModelClasses() {
        List<Class<? extends Model>> result = new ArrayList<>();
        try {

            String packageName = Fluentness.INSTANCE.appPackage + OnionArchitecture.DATA;
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
            Log.INSTANCE.error(e);
        }
        return result;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}
