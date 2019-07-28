package org.fluentness.base.common;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.exception.DefinitionException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public abstract class Architecture<I> {

    private static int lastDefinitionPriority = -1000;
    private static final Map<Class, Object> instances = new LinkedHashMap<>();
    private boolean allowDefinition = true;

    public void disallowDefinition() {
        allowDefinition = false;
    }

    public Architecture<I> add(Class<? extends I> iClass) throws DefinitionException {
        if (allowDefinition) {
            validateDefinition(iClass);
            validateInstantiation(iClass);
            instantiateWithDependencyInjection(iClass);
        } else {
            throw new DefinitionException("Definition is not allowed anymore");
        }
        return this;
    }

    private void validateDefinition(Class<? extends I> iClass) throws DefinitionException {
        int definitionPriority = getDefinitionPriority(iClass);
        if (definitionPriority == -1000) {
            throw new DefinitionException(
                "No definition priority annotation defined for %s, its superclass or its first interface",
                iClass.getSimpleName()
            );
        }
        if (definitionPriority < lastDefinitionPriority) {
            throw new DefinitionException(
                "Class %s has a definition priority of %s, last defined instance had %s, which is higher",
                iClass.getSimpleName(),
                definitionPriority,
                lastDefinitionPriority
            );
        }
        lastDefinitionPriority = definitionPriority;
    }

    private int getDefinitionPriority(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DefinitionPriority.class)) {
            return clazz.getAnnotation(DefinitionPriority.class).value();
        }
        if (clazz.getInterfaces().length > 0) {
            for (Class<?> anInterface : clazz.getInterfaces()) {
                int i = getDefinitionPriority(anInterface);
                if (i != -1000) {
                    return i;
                }
            }
        }
        if (!clazz.getSuperclass().equals(Object.class)) {
            return getDefinitionPriority(clazz.getSuperclass());
        }
        return -1000;
    }

    private void validateInstantiation(Class<? extends I> iClass) throws DefinitionException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new DefinitionException(
                "%s cannot be an interface in order to be instantiated",
                iClass.getSimpleName()
            );
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new DefinitionException(
                "%s cannot be an abstract class in order to be instantiated",
                iClass.getSimpleName()
            );
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new DefinitionException(
                "%s must be public in order to be instantiated",
                iClass.getSimpleName()
            );
        }
        if (iClass.getConstructors().length > 1) {
            throw new DefinitionException(
                "%s may have only one public constructor without parameters, inject dependencies using @Inject",
                iClass.getSimpleName()
            );
        }
        try {
            if (!Modifier.isPublic(iClass.getConstructor().getModifiers())) {
                throw new DefinitionException(
                    "%s may have only one public constructor without parameters, inject dependencies using @Inject",
                    iClass.getSimpleName()
                );
            }
        } catch (NoSuchMethodException e) {
            throw new DefinitionException(
                "%s may have only one public constructor without parameters, inject dependencies using @Inject",
                iClass.getSimpleName()
            );
        }

    }

    private void instantiateWithDependencyInjection(Class<? extends I> iClass) throws DefinitionException {
        try {
            I instance = iClass.newInstance();
            for (Field field : iClass.getFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    // inject dependency
                    field.set(instance, findDependencyToAssign(field));


                }
            }
            instances.put(iClass, instance);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DefinitionException(e);
        }
    }

    private Object findDependencyToAssign(Field field) throws DefinitionException {
        Class<?> type = field.getType();
        if (instances.containsKey(type)) {
            return instances.get(type);
        }
        return instances.values().stream()
            .filter(instance -> type.isAssignableFrom(instance.getClass()))
            .findAny()
            .orElseThrow(() -> new DefinitionException(
                "Cannot find suitable, previously defined dependency for field %s of class %s",
                field.getName(),
                field.getDeclaringClass().getSimpleName()
            ));
    }

}
