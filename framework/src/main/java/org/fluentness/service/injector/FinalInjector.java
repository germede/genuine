package org.fluentness.service.injector;

import org.fluentness.ApplicationComponent;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.loader.FinalLoader;
import org.fluentness.service.loader.Loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FinalInjector implements Injector {

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public FinalInjector(Loader loader,
                         List<Class<? extends Service>> services,
                         List<Class<? extends Repository>> repositories,
                         List<Class<? extends Controller>> controllers
    ) throws InjectorException {
        // add itself and loader service for other classes
        instances.put(Injector.class, this);
        instances.put(FinalInjector.class, this);
        instances.put(Loader.class, loader);
        instances.put(FinalLoader.class, loader);

        // instantiate application components
        for (Class<? extends Service> service : services) instantiate(service);
        for (Class<? extends Repository> repository : repositories) instantiate(repository);
        for (Class<? extends Controller> controller : controllers) instantiate(controller);
    }

    @Override
    public <A extends ApplicationComponent> List<A> getInstances(Class<A> parent) {
        List<A> result = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass()) && !result.contains((A) value)) {
                result.add((A) value);
            }
        }
        return result;
    }

    @Override
    public <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    private void instantiate(Class iClass) throws InjectorException {
        try {
            validateInstantiation(iClass);

            Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                // it no constructor, instantiate it directly without parameters
                instances.put(iClass, iClass.newInstance());
                handleServiceInterface(iClass);
            } else {
                // otherwise inject dependencies
                Parameter[] parameters = declaredConstructors[0].getParameters();
                Object[] parametersToInject = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Class<?> type = parameters[i].getType();
                    if (instances.containsKey(type)) {
                        parametersToInject[i] = instances.get(type);
                    } else {
                        if (ApplicationComponent.class.isAssignableFrom(type)) {
                            throw new InjectorException(
                                "Could not resolve dependencies correctly. Ensure that:\n" +
                                    "    a) %s is added after %s or\n" +
                                    "    b) %s doesn't depend on %s\n",
                                iClass.getSimpleName(),
                                type.getSimpleName(),
                                iClass.getSimpleName(),
                                type.getSimpleName()
                            );
                        } else {
                            throw new InjectorException("%s is not an application component", type.getSimpleName());
                        }
                    }
                }
                instances.put(iClass, declaredConstructors[0].newInstance(parametersToInject));
                handleServiceInterface(iClass);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectorException(e);
        }
    }

    private void validateInstantiation(Class iClass) throws InjectorException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new InjectorException("%s cannot be an interface in order to be instantiated", iClass.getName());
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new InjectorException("%s cannot be abstract in order to be instantiated", iClass.getName());
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new InjectorException("%s must be public in order to be instantiated", iClass.getName());
        }
        Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new InjectorException("%s may only have one or none public constructor", iClass.getName());
        }
    }

    private void handleServiceInterface(Class iClass) {
        if (Service.class.isAssignableFrom(iClass)) {
            // service interface is directly implemented
            for (Class iClassInterface : iClass.getInterfaces()) {
                if (Service.class.isAssignableFrom(iClassInterface)) {
                    instances.put(iClassInterface, instances.get(iClass));
                }
            }
            // retrieve interface recursively through the super classes
            Class superClass = iClass.getSuperclass();
            while (!superClass.equals(Object.class)) {
                for (Class superClassInterface : superClass.getInterfaces()) {
                    if (Service.class.isAssignableFrom(superClassInterface)) {
                        instances.put(superClassInterface, instances.get(iClass));
                    }
                }
                superClass = superClass.getSuperclass();
            }
        }
    }

    private Service.Type getServiceType(Class<? extends Service> serviceClass) {
        return serviceClass.isAnnotationPresent(Service.ServiceType.class) ?
            serviceClass.getAnnotation(ServiceType.class).value() :
            Type.MULTIPLE;
    }

}
