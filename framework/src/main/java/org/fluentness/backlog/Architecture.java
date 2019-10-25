package org.fluentness.backlog;

import org.fluentness.base.exception.DefinitionException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Architecture<I> {

    protected static final Map<Class, Object> instances = new LinkedHashMap<>();
    private boolean allowDefinition = true;

    public void disallowDefinition() {
        allowDefinition = false;
    }

    public Architecture<I> add(Class<? extends I> iClass) throws DefinitionException {
        if (allowDefinition) {
            validateInstantiation(iClass);
            instantiateWithDependencyInjection(iClass);
        } else {
            throw new DefinitionException("Definition is not allowed anymore");
        }
        return this;
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

            //

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
