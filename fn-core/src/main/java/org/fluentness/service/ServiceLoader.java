package org.fluentness.service;

import org.fluentness.Application;

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
                Class key = Service.getServiceInterface(service);
                if (!services.containsKey(key)) services.put(key, new LinkedList<>());
                List<Class> implementations = services.get(key);
                if (!key.isAnnotationPresent(MultiService.class)) implementations.clear();
                implementations.add(service);
            }
        });
    }

    public Map<Class, List<Class>> getServices() {
        return services;
    }
}