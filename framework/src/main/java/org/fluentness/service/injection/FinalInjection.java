package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.ApplicationComponent;
import org.fluentness.controller.Controller;
import org.fluentness.controller.console.FluentnessController;
import org.fluentness.service.Service;
import org.fluentness.service.authentication.DefaultAuthentication;
import org.fluentness.service.configuration.DefaultConfiguration;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.router.DefaultRouter;
import org.fluentness.service.server.SunServer;
import org.fluentness.service.translator.DefaultTranslator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public final class FinalInjection implements Injection {

    private static final List<Class<? extends Service>> defaultServices = Arrays.asList(
        JulLog.class,
        SocketMail.class,
        FilePersistence.class,
        SunServer.class,
        DefaultRouter.class,
        DefaultConfiguration.class,
        DefaultTranslator.class,
        DefaultAuthentication.class
    );
    private static final List<Class<? extends Controller>> defaultControllers = Collections.singletonList(FluentnessController.class);

    private Map<Class, Object> instances;

    @Override
    public Map<Class, Object> inject(Application application) throws InjectionException {
        instances = new HashMap<>();
        inject(application.getServices());
        inject(defaultServices);
        inject(application.getRepositories());
        inject(application.getControllers());
        inject(defaultControllers);
        return instances;
    }

    private <I extends ApplicationComponent> void inject(List<Class<? extends I>> classes) throws
        InjectionException {
        List<Class<? extends I>> notInstantiated = new LinkedList<>();
        for (Class<? extends I> clazz : classes) {
            Class key = getKey(clazz);
            if (!instances.containsKey(key)) {
                Object instance = instantiate(clazz);
                if (instance instanceof Class) {
                    notInstantiated.add(clazz);
                } else {
                    instances.put(key, instance);
                }
            }
        }
        if (notInstantiated.size() >= classes.size()) {
            throw new InjectionException(
                "Cannot resolve dependency instantiating [%s]. Possible cause: Circle dependency.",
                notInstantiated.stream().map(Class::getSimpleName).collect(Collectors.joining(", "))
            );
        }
        if (notInstantiated.size() > 0) {
            inject(notInstantiated);
        }
    }

    private Class<? extends ApplicationComponent> getKey(Class<? extends ApplicationComponent> aClass) {
        if (!Service.class.isAssignableFrom(aClass)) {
            return aClass;
        }
        Class currentClass = aClass;
        while (!currentClass.equals(Object.class)) {
            for (Class anInterface : currentClass.getInterfaces()) {
                if (anInterface.equals(Service.class)) {
                    return currentClass;
                }
                if (Service.class.isAssignableFrom(anInterface)) {
                    return anInterface;
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    private Object instantiate(Class aClass) throws InjectionException {
        validate(aClass);
        try {
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                // no dependencies, just instantiate
                return aClass.newInstance();
            }

            Constructor constructor = declaredConstructors[0];
            Parameter[] parameters = constructor.getParameters();
            Object[] result = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Class<?> type = parameters[i].getType();
                if (instances.containsKey(type)) {
                    result[i] = instances.get(type);
                } else {
                    return type;
                }
            }
            return constructor.newInstance(result);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new InjectionException(e);
        }
    }

    private void validate(Class aClass) throws InjectionException {
        if (Modifier.isInterface(aClass.getModifiers())) {
            throw new InjectionException("%s's class cannot be an interface in order to be instantiated", aClass.getName());
        }
        if (Modifier.isAbstract(aClass.getModifiers())) {
            throw new InjectionException("%s's class cannot be abstract in order to be instantiated", aClass.getName());
        }
        if (!Modifier.isPublic(aClass.getModifiers())) {
            throw new InjectionException("%s's class must be public in order to be instantiated", aClass.getName());
        }
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            if (!Modifier.isPublic(declaredConstructors[0].getModifiers())) {
                throw new InjectionException("%s's first constructor should be public", aClass.getName());
            }

            for (Class parameterType : declaredConstructors[0].getParameterTypes()) {
                if (!ApplicationComponent.class.isAssignableFrom(parameterType)) {
                    throw new InjectionException("%s constructor parameters should be ApplicationComponent", aClass.getName());
                }
            }
        }
    }
}