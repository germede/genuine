package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.Application.Platform;
import org.fluentness.ApplicationComponent;
import org.fluentness.controller.Controller;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.DefaultConfiguration;
import org.fluentness.service.injection.initer.Controllers;
import org.fluentness.service.injection.initer.Repositories;
import org.fluentness.service.injection.initer.Services;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.translator.DefaultTranslator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class FinalInjection implements Injection {

    @Override
    public Platform inject(Application application) throws InjectionException {

        Services services = new Services();
        Repositories repositories = new Repositories();
        Controllers controllers = new Controllers();
        Platform platform = application.init(services, repositories, controllers);

        inject(withFallbackServices(services, platform));
        inject(repositories.get());
        inject(withFallbackControllers(controllers, platform));

        return platform;
    }

    private List<Class<? extends Service>> withFallbackServices(Services services, Platform platform) {
        List<Class<? extends Service>> serviceList = services.get();
        switch (platform) {
            case WEB:
//                serviceList.add(DefaultAuthentication.class);
//                serviceList.add(SunServer.class);
//                serviceList.add(DefaultRouter.class);
                serviceList.add(JdbcPersistence.class);
            case DESKTOP:
//                serviceList.add(SocketMail.class);
                serviceList.add(JulLog.class);
            case MOBILE:
//                serviceList.add(AndroidLog.class);
//                serviceList.add(AndroidPersistence.class);
            case CONSOLE:
                serviceList.add(FilePersistence.class);
                serviceList.add(DefaultConfiguration.class);
                serviceList.add(DefaultTranslator.class);
        }
        return serviceList;
    }

    private List<Class<? extends Controller>> withFallbackControllers(Controllers controllers, Platform platform) {
        List<Class<? extends Controller>> controllerList = controllers.get();
//        switch (platform) {
//            case WEB:
//                controllerList.removeIf(aClass -> !AbstractWebController.class.isAssignableFrom(aClass));
//                break;
//            case DESKTOP:
//                controllerList.removeIf(aClass -> !AbstractDesktopController.class.isAssignableFrom(aClass));
//                break;
//            case MOBILE:
//                controllerList.removeIf(aClass -> !AbstractMobileController.class.isAssignableFrom(aClass));
//                break;
//            case CONSOLE:
//                controllerList.removeIf(aClass -> !AbstractConsoleController.class.isAssignableFrom(aClass));
//                controllerList.add(FluentnessController.class);
//                break;
//        }
        return controllerList;
    }

    private <I extends ApplicationComponent> void inject(List<Class<? extends I>> classes) throws
        InjectionException {
        List<Class<? extends I>> notInstantiated = new LinkedList<>();
        List<Class<? extends I>> keysToIgnore = new LinkedList<>();
        for (Class<? extends I> clazz : classes) {
            Class key = getKey(clazz);
            if (!keysToIgnore.contains(key)) {
                Object instance = instantiate(clazz);
                if (instance instanceof Class) {
                    notInstantiated.add(clazz);
                } else {
                    instances.put(key, instance);
                }
                keysToIgnore.add(key);
            }
        }
        if (notInstantiated.size() > 0) {
            if (notInstantiated.size() >= classes.size()) {
                throw new InjectionException(
                    "Cannot resolve dependency instantiating [%s]. Possible cause: Circle dependency.",
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