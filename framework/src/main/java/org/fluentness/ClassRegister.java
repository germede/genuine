package org.fluentness;

import org.fluentness.service.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum ClassRegister {
    does;

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public <T> List<T> getInstances(Class<T> tClass) {
        List<T> result = new ArrayList<>();
        for (Object value : instances.values()) {
            if (tClass.isAssignableFrom(value.getClass())) {
                result.add((T) value);
            }
        }
        return result;
    }

    public <T> T getInstance(Class<T> tClass) {
        return (T) instances.get(tClass);
    }

    void inject(List<Class> classes) throws InjectionException {
        for (Class aClass : classes) {
            inject(aClass);
        }
    }

    private void inject(Class aClass) throws InjectionException {
        validateInstantiation(aClass);
        instantiate(aClass);
    }

    private void validateInstantiation(Class iClass) throws InjectionException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new InjectionException("%s cannot be an interface in order to be instantiated", iClass.getName());
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new InjectionException("%s cannot be abstract in order to be instantiated", iClass.getName());
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new InjectionException("%s must be public in order to be instantiated", iClass.getName());
        }
        Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new InjectionException("%s may only have one or none public constructor", iClass.getName());
        }
    }

    private void instantiate(Class iClass) throws InjectionException {
        // if service don't use implementation class but interface
        Class instanceKey = Service.class.isAssignableFrom(iClass) ? getInterfaceForServiceClass(iClass) : iClass;

        // don't override implementations
        if (instances.containsKey(instanceKey)) {
            return;
        }

        try {
            // it no constructor, instantiate it directly without parameters
            Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                instances.put(instanceKey, iClass.newInstance());
            } else {
                // otherwise inject dependencies
                Parameter[] parameters = declaredConstructors[0].getParameters();
                Object[] parametersToInject = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    if (instances.containsKey(parameter.getType())) {
                        parametersToInject[i] = instances.get(parameter.getType());
                    } else {
                        inject(parameter.getType());
                        i--;
                    }
                }
                instances.put(instanceKey, declaredConstructors[0].newInstance(parametersToInject));
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectionException(e);
        }
    }

    private Class getInterfaceForServiceClass(Class<? extends Service> sClass) {
        // service interface is directly implemented
        for (Class sClassInterface : sClass.getInterfaces()) {
            if (sClassInterface.equals(Service.class)) {
                return sClass;
            }
            if (Service.class.isAssignableFrom(sClassInterface)) {
                return sClassInterface;
            }
        }
        // retrieve interface recursively through the super classes
        Class superClass = sClass.getSuperclass();
        while (superClass != Object.class) {
            for (Class superClassInterface : superClass.getInterfaces()) {
                if (Service.class.isAssignableFrom(superClassInterface)) {
                    return superClassInterface;
                }
            }
            superClass = superClass.getSuperclass();
        }
        return sClass;
    }

    static class InjectionException extends AbstractException {
        InjectionException(Exception exception) {
            super(exception);
        }

        InjectionException(String messageToFormat, Object... parameters) {
            super(messageToFormat, parameters);
        }
    }
}
