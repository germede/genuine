package org.fluentness.service;

import org.fluentness.Application;
import org.fluentness.FluentnessException;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class ServiceLoader {

    private final Map<Class, List<Class>> services = new HashMap<>();

    public ServiceLoader(Class<? extends Application> applicationClass) {
        List<Class<?>> applicationHierarchy = new LinkedList<>();
        applicationHierarchy.add(Application.class);
        applicationHierarchy.add(applicationClass.getSuperclass());
        applicationHierarchy.add(applicationClass);

        applicationHierarchy.stream().filter(clazz -> clazz.isAnnotationPresent(Services.class)).forEach(clazz -> {
            for (Class<? extends Service> service : clazz.getAnnotation(Services.class).value()) {
                Class key = getKey(service);
                if (!services.containsKey(key)) services.put(key, new LinkedList<>());
                List<Class> implementations = services.get(key);
                if (!key.isAnnotationPresent(AllowMultipleImplementations.class)) implementations.clear();
                implementations.add(service);
            }
        });
    }

    private Class getKey(Class aClass) {
        if (!Service.class.isAssignableFrom(aClass)) return aClass;
        do {
            for (Class anInterface : aClass.getInterfaces()) {
                if (anInterface.equals(Service.class)) return aClass;
                if (Service.class.isAssignableFrom(anInterface)) return anInterface;
            }
        } while ((aClass = aClass.getSuperclass()) != null);
        return Service.class;
    }

    public Map<Class, List<Class>> getServices() {
        return services;
    }
}