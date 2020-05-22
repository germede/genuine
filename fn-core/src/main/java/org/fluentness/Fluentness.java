package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.model.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.Services;
import org.fluentness.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
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

    private final Map<Class, Class> aliases = new HashMap<>();
    private final Map<Class, Object> instances = new HashMap<>();


    public Fluentness(Class<? extends Application> applicationClass, String[] args) throws FluentnessException {
        try {
            aliases(applicationClass);
            application = instantiate(applicationClass);
            application.run(args);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    private void aliases(Class<? extends Application> aClass) throws FluentnessException {
        do {
            if (aClass.isAnnotationPresent(Services.class)) {
                Arrays.stream(aClass.getAnnotation(Services.class).value())
                    .forEach(service -> aliases.putIfAbsent(getKey(service), service));
            }
            aClass = (Class<? extends Application>) aClass.getSuperclass();
        } while (aClass != null && Application.class.isAssignableFrom(aClass));
        Arrays.stream(Application.class.getAnnotation(Services.class).value())
            .forEach(service -> aliases.putIfAbsent(getKey(service), service));
    }

    private <T> T instantiate(Class<T> aClass) throws FluentnessException {
        Constructor constructor = getConstructor(aClass);
        try {
            T instance;
            if (constructor.getParameterCount() == 0) instance = aClass.newInstance();
            else instance = (T) constructor.newInstance(getParameters(constructor));
            instances.put(getKey(aClass), instance);
            instances.put(aClass, instance);
            return instance;
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new FluentnessException(e);
        }
    }

    private Constructor getConstructor(Class aClass) throws FluentnessException {
        if (Modifier.isInterface(aClass.getModifiers()))
            throw new FluentnessException("%s cannot be an interface in order to be instantiated. Forgot to declare service implementation?", aClass.getSimpleName());
        if (Modifier.isAbstract(aClass.getModifiers()))
            throw new FluentnessException("%s cannot be abstract in order to be instantiated", aClass.getSimpleName());
        if (!Modifier.isPublic(aClass.getModifiers()))
            throw new FluentnessException("%s must be public in order to be instantiated", aClass.getSimpleName());
        return Arrays.stream(aClass.getConstructors())
            .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
            .findFirst()
            .orElseThrow(() -> new FluentnessException("%s should have at least one public constructor", aClass.getSimpleName()));
    }

    private <T> Object[] getParameters(Constructor<T> constructor) throws FluentnessException {
        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            validateDependency(constructor.getDeclaringClass(), type);

            if (type.isAssignableFrom(Object[].class)) {
                int ia = 0;
            }



            if (instances.containsKey(type)) {
                result[i] = instances.get(type);
            } else {
                result[i] = instantiate(aliases.getOrDefault(type, type));
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
}