package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.model.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.AllowMultipleImplementations;
import org.fluentness.service.Service;
import org.fluentness.service.Services;
import org.fluentness.view.View;

import java.lang.reflect.*;
import java.util.*;

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

    private final Map<Class, List<Class>> serviceImplementations = new HashMap<>();
    private final Map<Class, Object> instances = new HashMap<>();


    public Fluentness(Class<? extends Application> applicationClass, String[] args) throws FluentnessException {
        try {
            retrieveServiceImplementations(applicationClass);
            application = instantiate(applicationClass);
            application.run(args);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    private void retrieveServiceImplementations(Class<? extends Application> applicationClass) throws FluentnessException {
        List<Class<?>> applicationHierarchy = new LinkedList<>();
        applicationHierarchy.add(Application.class);
        applicationHierarchy.add(applicationClass.getSuperclass());
        applicationHierarchy.add(applicationClass);

        applicationHierarchy.stream().filter(clazz -> clazz.isAnnotationPresent(Services.class)).forEach(clazz -> {
            for (Class<? extends Service> service : clazz.getAnnotation(Services.class).value()) {
                Class key = getKey(service);
                if (!serviceImplementations.containsKey(key)) serviceImplementations.put(key, new LinkedList<>());
                List<Class> implementations = serviceImplementations.get(key);
                if (!key.isAnnotationPresent(AllowMultipleImplementations.class)) implementations.clear();
                implementations.add(service);
            }
        });
    }

    private <T> T instantiate(Class<T> aClass) throws FluentnessException {
        Constructor constructor = getConstructor(aClass);
        try {
            T instance;
            if (constructor.getParameterCount() == 0) {
                instance = aClass.newInstance();
            } else {
                instance = (T) constructor.newInstance(getParameters(constructor));
            }

            Class key = getKey(aClass);
            if (Service.class.isAssignableFrom(aClass) && !key.isAnnotationPresent(AllowMultipleImplementations.class)) {
                instances.put(key, instance);
            } else {
                instances.put(aClass, instance);
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
                List<Class> classes = serviceImplementations.get(arrayType);

                result[i] = Array.newInstance(arrayType, classes.size());
                for (int j = 0; j < classes.size(); j++) {
                    ((Object[]) result[i])[j] = instantiate(classes.get(j));
                }
            } else {
                validateDependency(constructor.getDeclaringClass(), parameterClass);
                List<Class> implementations = serviceImplementations.get(parameterClass);
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