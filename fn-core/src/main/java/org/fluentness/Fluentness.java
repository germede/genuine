package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.model.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.service.ServiceLoader;
import org.fluentness.view.View;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Fluentness {

    private static final Class<?>[] injectionPriority = new Class[]{
        Model.class,
        Service.class,
        Repository.class,
        View.class,
        Controller.class,
        Application.class,
    };
    public static Application application;


    public static void launch(Class<? extends Application> applicationClass, String[] args) throws FluentnessException {
        new Fluentness(applicationClass, args);
    }

    private final Map<Class, List<Class>> services;
    private final Map<Class, Object> instances = new HashMap<>();

    public Fluentness(Class<? extends Application> applicationClass, String[] args) throws FluentnessException {
        try {
            services = new ServiceLoader(applicationClass).getServices();
            application = instantiate(applicationClass);
            application.run(args);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }


    private <T> T instantiate(Class<T> aClass) throws FluentnessException {
        Constructor constructor = getConstructor(aClass);
        try {
            T instance;
            if (constructor.getParameterCount() == 0) instance = aClass.newInstance();
            else instance = (T) constructor.newInstance(getParameters(constructor));
            instances.put(aClass, instance);
            if (Service.class.isAssignableFrom(aClass) && !aClass.isAnnotationPresent(MultiService.class)) {
                instances.put(Service.getServiceInterface(aClass), instance);
            }
            return instance;
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new FluentnessException(e);
        }
    }

    private Constructor getConstructor(Class aClass) throws FluentnessException {
        return Arrays.stream(aClass.getConstructors())
            .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
            .findFirst()
            .orElseThrow(() -> new FluentnessException("%s should have at least one public constructor", aClass.getSimpleName()));
    }

    private <T> Object[] getParameters(Constructor<T> constructor) throws FluentnessException {
        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameterClass = parameters[i].getType();

            if (instances.containsKey(parameterClass)) {
                result[i] = instances.get(parameterClass);
            } else if (parameterClass.isArray()) {
                Class<?> arrayType = parameterClass.getComponentType();
                validateDependency(constructor.getDeclaringClass(), arrayType);
                List<Class> classes = services.get(arrayType);
                if (classes != null) {
                    result[i] = Array.newInstance(arrayType, classes.size());
                    for (int j = 0; j < classes.size(); j++) {
                        ((Object[]) result[i])[j] = instantiate(classes.get(j));
                    }
                } else {
                    result[i] = null;
                }
            } else {
                validateDependency(constructor.getDeclaringClass(), parameterClass);
                List<Class> implementations = services.get(parameterClass);
                result[i] = instantiate(
                    implementations != null && implementations.size() > 0 ?
                        implementations.get(0) :
                        parameterClass
                );
            }
        }
        return result;
    }

    private void validateDependency(Class<?> dependant, Class<?> dependency) throws FluentnessException {
        int dependantPriority = -1, dependencyPriority = -1;
        for (int i = 0; i < injectionPriority.length; i++) {
            if (injectionPriority[i].isAssignableFrom(dependant)) dependantPriority = i;
            if (injectionPriority[i].isAssignableFrom(dependency)) dependencyPriority = i;
        }
        if (dependantPriority < dependencyPriority) {
            throw new FluentnessException("A %s cannot depend on a %s", dependant.getSimpleName(), dependency.getSimpleName());
        }
    }
}