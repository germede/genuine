package org.fluentness.service.injector;

import org.fluentness.Application;
import org.fluentness.controller.Controller;
import org.fluentness.model.PersistableModel;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructorInjector implements Injector {

    private final Class<?>[] injectionPriority =
        new Class[]{PersistableModel.class, Service.class, Repository.class, View.class, Controller.class, Application.class};
    private final Map<Class, Object> instances = new HashMap<>();

    @Override
    public Application inject(Class<? extends Application> applicationClass) throws InjectorException {
        try {
            return instanceOf(applicationClass);
        } catch (Throwable cause) {
            throw new InjectorException(cause);
        }
    }

    private <T> T instanceOf(Class<T> aClass) throws InjectorException {
        Constructor constructor = getConstructor(aClass);
        try {
            T instance;
            if (constructor.getParameterCount() == 0) instance = aClass.newInstance();
            else instance = (T) constructor.newInstance(getParameters(constructor));
            instances.put(aClass, instance);
            if (Service.class.isAssignableFrom(aClass)) {
                instances.put(Service.getServiceInterface(aClass), instance);
            }
            return instance;
        } catch (IllegalAccessException | InvocationTargetException | java.lang.InstantiationException e) {
            throw new InjectorException(e);
        }
    }

    private Constructor getConstructor(Class aClass) throws InjectorException {
        return Arrays.stream(aClass.getConstructors())
            .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
            .findFirst()
            .orElseThrow(() -> new InjectorException("%s is not instantiable", aClass.getSimpleName()));
    }

    private <T> Object[] getParameters(Constructor<T> constructor) throws InjectorException {
        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameterClass = parameters[i].getType();

            if (instances.containsKey(parameterClass)) {
                result[i] = instances.get(parameterClass);
            } else {
                validateDependency(constructor.getDeclaringClass(), parameterClass);
                Class implementation = DefaultImplementations.get(parameterClass);
                result[i] = instanceOf(implementation != null ? implementation : parameterClass);
            }
        }
        return result;
    }

    private void validateDependency(Class<?> dependant, Class<?> dependency) throws InjectorException {
        int dependantPriority = -1, dependencyPriority = -1;
        for (int i = 0; i < injectionPriority.length; i++) {
            if (injectionPriority[i].isAssignableFrom(dependant)) dependantPriority = i;
            if (injectionPriority[i].isAssignableFrom(dependency)) dependencyPriority = i;
        }
        if (dependantPriority < dependencyPriority) {
            throw new InjectorException("A %s should not depend on a %s", dependant.getSimpleName(), dependency.getSimpleName());
        }
    }
}
