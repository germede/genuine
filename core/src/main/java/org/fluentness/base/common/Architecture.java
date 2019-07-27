package org.fluentness.base.common;

import org.fluentness.base.common.exception.DefinitionException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Architecture<E extends ArchitectureElement> {

    private static int lastDefinitionPriority = -1000;

    private final Map<Class, E> instances = new LinkedHashMap<>();

    public boolean has(Class eClass) {
        return instances.containsValue(eClass);
    }

    public E get(Class key) {
        return instances.get(key);
    }

    public Architecture<E> add(E instance) throws DefinitionException {
        int definitionPriority = instance.getDefinitionPriority();
        if (definitionPriority < lastDefinitionPriority) {
            throw new DefinitionException(
                "Instance %s has a definition priority of %s, last defined instance had %s, which is higher. ",
                instance.getClass().getSimpleName(),
                definitionPriority,
                lastDefinitionPriority
            );
        }

        Arrays.stream(getKeysThatWillPointTo(instance)).forEach(key ->
            instances.put(key, instance)
        );
        lastDefinitionPriority = definitionPriority;
        return this;
    }

    @SafeVarargs
    protected final <T> T[] array(T... varargs) {
        return varargs;
    }

    protected abstract Class<? extends E>[] getKeysThatWillPointTo(E instance);
}
