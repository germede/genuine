package org.fluentness.base.common;

import org.fluentness.Fluentness;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.common.exception.InjectionException;

import java.util.HashMap;
import java.util.Map;

public abstract class Architecture<K, V> {

    protected final Map<Class<K>, Class<V>> defined = new HashMap<>();

    private final Map<Class<K>, V> applied = new HashMap<>();

    private Fluentness app;

    public Architecture(Fluentness app) {
        this.app = app;
    }

    public void set(Class<? extends K> key, Class<? extends V> value) {
        defined.put((Class<K>) key, (Class<V>) value);
    }

    public V get(Class<K> key) {
        return applied.get(key);
    }

    public void applyDefinition() throws InjectionException, DefinitionException {
        for (Map.Entry<Class<K>, Class<V>> entry : defined.entrySet()) {
            validateDefinition(entry.getKey(), entry.getValue());
            applied.put(entry.getKey(), app.instantiateInjecting(entry.getValue()));
        }
    }

    protected abstract void validateDefinition(Class<K> key, Class<V> value) throws DefinitionException;
}
