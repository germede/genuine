package org.fluentness.service.injection;

import org.fluentness.ApplicationComponent;
import org.fluentness.Fluentness;
import org.fluentness.service.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

public class DefaultInjectionService implements InjectionService {

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public DefaultInjectionService() {
        // add itself as first injection for other classes
        instances.put(InjectionService.class, this);
    }

    @Override
    public <T extends ApplicationComponent> List<T> getInstances(Class<T> parent) {
        List<T> result = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                result.add((T) value);
            }
        }
        return result;
    }

    @Override
    public <T extends ApplicationComponent> T getInstance(Class<T> tClass) {
        return (T) instances.get(tClass);
    }

    @Override
    public <T extends ApplicationComponent> void inject(Fluentness proxy, List<Class<? extends T>> classes) throws InjectionException {
        for (Class aClass : classes) {
            validateInstantiation(aClass);
            instantiate(aClass);
        }
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
                    Class<?> type = parameters[i].getType();
                    if (instances.containsKey(type)) {
                        parametersToInject[i] = instances.get(type);
                    } else {
                        if (ApplicationComponent.class.isAssignableFrom(type)) {
                            throw new InjectionException(
                                "Could not resolve dependencies correctly. Ensure that:\n" +
                                    "    a) %s is added after %s or\n" +
                                    "    b) %s doesn't depend on %s\n",
                                iClass.getSimpleName(),
                                type.getSimpleName(),
                                iClass.getSimpleName(),
                                type.getSimpleName()
                            );
                        } else {
                            throw new InjectionException("%s is not an application component", type.getSimpleName());
                        }
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

}
