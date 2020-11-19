package org.fluentness.service.injector;

import org.fluentness.Application;
import org.fluentness.controller.Controller;
import org.fluentness.model.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.Services;
import org.fluentness.view.View;

import java.lang.reflect.*;
import java.util.*;

public class ConstructorInjector implements Injector {

    private final Class<?>[] injectionPriority = new Class[]{
        Model.class,
        Service.class,
        Repository.class,
        View.class,
        Controller.class,
        Application.class,
    };
    private final Map<Class, List<Class>> services = new HashMap<>();
    private final Map<Class, Object> instances = new HashMap<>();

    @Override
    public Application inject(Class<? extends Application> applicationClass) throws InjectorException {
        try {
            getServices(applicationClass);
            return instanceOf(applicationClass);
        } catch (Throwable cause) {
            throw new InjectorException(cause);
        }
    }

    private void getServices(Class<? extends Application> applicationClass) {
        List<Class<?>> applicationHierarchy = new LinkedList<>();
        applicationHierarchy.add(Application.class);
        applicationHierarchy.add(applicationClass.getSuperclass());
        applicationHierarchy.add(applicationClass);

        applicationHierarchy.stream().filter(clazz -> clazz.isAnnotationPresent(Services.class)).forEach(clazz -> {
            for (Class<? extends Service> service : clazz.getAnnotation(Services.class).value()) {
                Class key = Service.getServiceInterface(service);
                if (!services.containsKey(key)) services.put(key, new LinkedList<>());
                List<Class> implementations = services.get(key);
                if (!key.isAnnotationPresent(Service.MultiService.class)) implementations.clear();
                implementations.add(service);
            }
        });
    }

    private <T> T instanceOf(Class<T> aClass) throws InjectorException {
        Constructor constructor = getConstructor(aClass);
        try {
            T instance;
            if (constructor.getParameterCount() == 0) instance = aClass.newInstance();
            else instance = (T) constructor.newInstance(getParameters(constructor));
            instances.put(aClass, instance);
            if (Service.class.isAssignableFrom(aClass) && !aClass.isAnnotationPresent(Service.MultiService.class)) {
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
            } else if (parameterClass.isArray()) {
                Class<?> arrayType = parameterClass.getComponentType();
                validateDependency(constructor.getDeclaringClass(), arrayType);
                List<Class> classes = services.get(arrayType);
                if (classes != null) {
                    result[i] = Array.newInstance(arrayType, classes.size());
                    for (int j = 0; j < classes.size(); j++) {
                        ((Object[]) result[i])[j] = instanceOf(classes.get(j));
                    }
                } else {
                    result[i] = null;
                }
            } else {
                validateDependency(constructor.getDeclaringClass(), parameterClass);
                List<Class> implementations = services.get(parameterClass);
                result[i] = instanceOf(
                    implementations != null && implementations.size() > 0 ?
                        implementations.get(0) :
                        parameterClass
                );
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
            throw new InjectorException("A %s cannot depend on a %s", dependant.getSimpleName(), dependency.getSimpleName());
        }
    }
}
