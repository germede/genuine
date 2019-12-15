package org.fluentness.injector;

import org.fluentness.Application;
import org.fluentness.ApplicationComponent;
import org.fluentness.configuration.Configuration;
import org.fluentness.logger.Logger;
import org.fluentness.mailer.Mailer;
import org.fluentness.persistence.Persistence;
import org.fluentness.server.Server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FnInjector implements Injector {

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public FnInjector(Application application) throws InjectorException {
        instances.put(Injector.class, this);
        instances.put(FnInjector.class, this);

        inject(application.getModels());
        inject(application.getLocalizations());
        inject(Configuration.class, application.getConfiguration());
        inject(Logger.class, application.getLogger());
        inject(Persistence.class, application.getPersistence());
        inject(Server.class, application.getServer());
        inject(Mailer.class, application.getMailer());
        inject(application.getViews());
        inject(application.getValidators());
        inject(application.getRepositories());
        inject(application.getControllers());
    }

    @Override
    public <A extends ApplicationComponent> List<A> getInstances(Class<A> parent) {
        return instances.values().stream()
            .filter(value -> parent.isAssignableFrom(value.getClass()))
            .map(o -> (A) o)
            .collect(Collectors.toList());
    }

    @Override
    public <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    private <A extends ApplicationComponent> void inject(List<Class<? extends A>> classList) throws InjectorException {
        for (Class single : classList) {
            instances.put(single, instantiate(single));
        }
    }

    private <A extends ApplicationComponent> void inject(Class<A> iClass, Class<? extends A> aClass) throws InjectorException {
        instances.put(iClass, instantiate(aClass));
    }

    private <A extends ApplicationComponent> A instantiate(Class<? extends A> aClass) throws InjectorException {
        try {
            validateInstantiation(aClass);
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                return aClass.newInstance();
            }

            Constructor constructor = declaredConstructors[0];
            return (A) constructor.newInstance(prepareConstructorParameters(aClass, constructor));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectorException(e);
        }
    }

    private <A extends ApplicationComponent> Object[] prepareConstructorParameters(Class<? extends A> aClass, Constructor constructor) throws InjectorException {
        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            if (instances.containsKey(type)) {
                result[i] = instances.get(type);
            } else {
                if (ApplicationComponent.class.isAssignableFrom(type)) {
                    throw new InjectorException(
                        "Cannot instantiate % because it cannot depend on %s",
                        aClass.getSimpleName(),
                        type.getSimpleName()
                    );
                } else {
                    throw new InjectorException("%s is not an application component", type.getSimpleName());
                }
            }
        }
        return result;
    }

    private void validateInstantiation(Class aClass) throws InjectorException {
        if (Modifier.isInterface(aClass.getModifiers())) {
            throw new InjectorException("%s's class cannot be an interface in order to be instantiated", aClass.getName());
        }
        if (Modifier.isAbstract(aClass.getModifiers())) {
            throw new InjectorException("%s's class cannot be abstract in order to be instantiated", aClass.getName());
        }
        if (!Modifier.isPublic(aClass.getModifiers())) {
            throw new InjectorException("%s's class must be public in order to be instantiated", aClass.getName());
        }
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new InjectorException("%s's first constructor should be public", aClass.getName());
        }
    }

}
