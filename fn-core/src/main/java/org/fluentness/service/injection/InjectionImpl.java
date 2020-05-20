package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.Src;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class InjectionImpl implements Injection {

    private final Application application;

    public InjectionImpl(Application application) {
        this.application = application;
    }

    @Override
    public void inject() throws InjectionException {
        inject(retrieve(Service.class));
        inject(retrieve(Repository.class));
        inject(retrieve(Controller.class));
    }

    private <C extends Application.Component> List<Class<? extends C>> retrieve(Class<C> component) {
        List<Class<? extends C>> result = new LinkedList<>();
        Class<?> currentClass = application.getClass();
        while (true) {
            // switch components
            if (currentClass.isAnnotationPresent(Src.class)) {
                if (component.equals(Service.class)) {
                    Class<? extends Service>[] services = currentClass.getAnnotation(Src.class).services();
                    Arrays.stream(services).forEach(aClass -> result.add((Class<? extends C>) aClass));
                } else if (component.equals(Repository.class)) {
                    Class<? extends Repository>[] repositories = currentClass.getAnnotation(Src.class).repositories();
                    Arrays.stream(repositories).forEach(aClass -> result.add((Class<? extends C>) aClass));
                } else if (component.equals(Controller.class)) {
                    Class<? extends Controller>[] controllers = currentClass.getAnnotation(Src.class).controllers();
                    Arrays.stream(controllers).forEach(aClass -> result.add((Class<? extends C>) aClass));
                }
            }
            // recursion upwards in the class hierarchy
            if (currentClass.getSuperclass() != null && Application.class.isAssignableFrom(currentClass.getSuperclass())) {
                currentClass = currentClass.getSuperclass();
            } else if (currentClass.getInterfaces().length > 0) {
                for (Class anInterface : currentClass.getInterfaces()) {
                    if (Application.class.isAssignableFrom(anInterface)) {
                        currentClass = anInterface;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }

    private <C extends Application.Component> void inject(List<Class<? extends C>> classes) throws InjectionException {
        List<Class<? extends C>> notInstantiated = new LinkedList<>();
        List<Class<? extends C>> singleServices = new LinkedList<>();
        for (Class<? extends C> clazz : classes) {
            Class key = getKey(clazz);
            if (!singleServices.contains(key)) {
                Object instance = instantiate(clazz);
                if (instance instanceof Class) {
                    notInstantiated.add(clazz);
                } else {
                    Fluentness.instances.put(key, instance);
                }
                singleServices.add(key);
            }
        }
        if (notInstantiated.size() > 0) {
            if (notInstantiated.size() >= classes.size()) {
                throw new InjectionException(
                    "Cannot resolve dependencies instantiating [%s], possible causes: Circle dependency or dependency not declared in application",
                    notInstantiated.stream().map(Class::getSimpleName).collect(Collectors.joining(", "))
                );
            }
            inject(notInstantiated);
        }
    }

    private Class getKey(Class aClass) {
        if (!Service.class.isAssignableFrom(aClass)) {
            return aClass;
        }
        Class currentClass = aClass;
        while (!currentClass.equals(Object.class)) {
            for (Class anInterface : currentClass.getInterfaces()) {
                if (anInterface.equals(Service.class)) {
                    return currentClass.isAnnotationPresent(MultiService.class) ? aClass : currentClass;
                }
                if (Service.class.isAssignableFrom(anInterface)) {
                    return anInterface.isAnnotationPresent(MultiService.class) ? aClass : anInterface;
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    private Object instantiate(Class aClass) throws InjectionException {
        Constructor constructor = getConstructor(aClass);
        try {
            if (constructor.getParameterCount() == 0) {
                // no dependencies, just instantiate
                return aClass.newInstance();
            }
            Parameter[] parameters = constructor.getParameters();
            Object[] result = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Class<?> type = parameters[i].getType();
                if (Fluentness.instances.containsKey(type)) {
                    result[i] = Fluentness.instances.get(type);
                } else if (!Application.Component.class.isAssignableFrom(type)) {
                    throw new InjectionException(
                        "All constructor parameters must be ApplicationComponents, %s's '%s' isn't",
                        aClass.getSimpleName(),
                        parameters[i].getName()
                    );
                } else if (View.class.isAssignableFrom(type)) {
                    if (Controller.class.isAssignableFrom(aClass)) {
                        result[i] = instantiate(type);
                    } else {
                        throw new InjectionException(
                            "%s depends on a View: Views can only be dependencies of controllers per definition!",
                            aClass
                        );
                    }
                } else {
                    // could not be instantiated, return type and try again later
                    return type;
                }
            }
            return constructor.newInstance(result);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new InjectionException(e);
        }
    }

    private Constructor getConstructor(Class aClass) throws InjectionException {
        if (Modifier.isInterface(aClass.getModifiers())) {
            throw new InjectionException("%s's class cannot be an interface in order to be instantiated", aClass.getName());
        }
        if (Modifier.isAbstract(aClass.getModifiers())) {
            throw new InjectionException("%s's class cannot be abstract in order to be instantiated", aClass.getName());
        }
        if (!Modifier.isPublic(aClass.getModifiers())) {
            throw new InjectionException("%s's class must be public in order to be instantiated", aClass.getName());
        }
        return Arrays.stream(aClass.getConstructors())
            .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
            .findFirst()
            .orElseThrow(() -> new InjectionException("%s should have at least one public constructor", aClass.getName()));

    }
}