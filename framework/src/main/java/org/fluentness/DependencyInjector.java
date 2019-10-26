package org.fluentness;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;

enum DependencyInjector {
    does;

    private Map<Class, Object> instances = new LinkedHashMap<>();

    <T> T[] getInstances(Class<T> tClass) {
        return (T[]) instances.values().stream().filter(o -> o.getClass().isAssignableFrom(tClass)).toArray();
    }

    void inject(Class... iClass) throws ClassInjectionException {
        for (Class aClass : iClass) {
            validateInstantiation(aClass);
            instantiateWithDependencyInjection(aClass);
        }
    }

    private void validateInstantiation(Class iClass) throws ClassInjectionException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new ClassInjectionException(
                    "%s cannot be an interface in order to be instantiated",
                    iClass.getSimpleName()
            );
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new ClassInjectionException(
                    "%s cannot be an abstract class in order to be instantiated",
                    iClass.getSimpleName()
            );
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new ClassInjectionException(
                    "%s must be public in order to be instantiated",
                    iClass.getSimpleName()
            );
        }
        if (iClass.getDeclaredConstructors().length == 0) {
            return;
        }
        try {
            if (iClass.getDeclaredConstructors().length > 1
                    || !Modifier.isPublic(iClass.getDeclaredConstructor().getModifiers())) {
                throw new ClassInjectionException(
                        "%s may have only one public constructor",
                        iClass.getSimpleName()
                );
            }
        } catch (NoSuchMethodException e) {
            throw new ClassInjectionException(
                    "%s may have only one public constructor",
                    iClass.getSimpleName()
            );
        }
    }

    private void instantiateWithDependencyInjection(Class iClass) throws ClassInjectionException {
        try {

            Object[] parametersToInject = new Object[iClass.getConstructor().getParameterCount()];
            Parameter[] parameters = iClass.getConstructor().getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                if (instances.containsKey(parameter.getType())) {
                    parametersToInject[i] = instances.get(parameter.getType());
                } else {
                    throw new ClassInjectionException("No parameter found");
                }
            }
            Object instance = iClass.getConstructor().newInstance(parametersToInject);

            instances.put(iClass, instance);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ClassInjectionException(e);
        }
    }

    static class ClassInjectionException extends AbstractException {

        ClassInjectionException(Exception exception) {
            super(exception);
        }

        ClassInjectionException(String messageToFormat, Object... parameters) {
            super(messageToFormat, parameters);
        }

    }
}
