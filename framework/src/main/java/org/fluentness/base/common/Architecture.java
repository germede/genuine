package org.fluentness.base.common;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.common.exception.DefinitionException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Architecture<I> {

    private static int lastDefinitionPriority = -1000;

    private final Map<Class, I> instances = new LinkedHashMap<>();
    private boolean allowDefinition = true;

    public Architecture<I> define(I instance) throws DefinitionException {
        if (allowDefinition) {
            Class<?> instanceClass = instance.getClass();
            Class<?> superclass = instanceClass.getSuperclass();
            Class<?>[] interfaces = instanceClass.getInterfaces();
            int definitionPriority =
                instanceClass.isAnnotationPresent(DefinitionPriority.class) ?
                    instanceClass.getAnnotation(DefinitionPriority.class).value() :
                    superclass.isAnnotationPresent(DefinitionPriority.class) ?
                        superclass.getAnnotation(DefinitionPriority.class).value() :
                        interfaces.length > 0 &&
                            getIClass().isAssignableFrom(interfaces[0]) &&
                            interfaces[0].isAnnotationPresent(DefinitionPriority.class) ?
                            interfaces[0].getAnnotation(DefinitionPriority.class).value() :
                            -1000;

            if (definitionPriority == -1000) {
                throw new DefinitionException(
                    "No definition priority annotation given for instance %s or its superclass or its first interface",
                    instanceClass.getSimpleName()
                );
            }
            if (definitionPriority < lastDefinitionPriority) {
                throw new DefinitionException(
                    "Instance %s has a definition priority of %s, last defined instance had %s, which is higher. ",
                    instanceClass.getSimpleName(),
                    definitionPriority,
                    lastDefinitionPriority
                );
            }

            Arrays.stream(getKeysThatWillPointTo(instance)).forEach(key ->
                instances.put(key, instance)
            );
            lastDefinitionPriority = definitionPriority;
        } else {
            throw new DefinitionException("Definition is not allowed anymore");
        }
        return this;
    }

    public void disallowDefinition() {
        allowDefinition = false;
    }

    protected boolean has(Class eClass) {
        return instances.containsValue(eClass);
    }

    protected I get(Class key) {
        return instances.get(key);
    }

    protected final <T> T[] array(T... varargs) {
        return varargs;
    }

    protected abstract Class<I> getIClass();

    protected abstract Class<? extends I>[] getKeysThatWillPointTo(I instance);
}
