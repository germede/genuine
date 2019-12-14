package org.fluentness.service.configurator;

import org.fluentness.Fluentness;

import java.util.HashMap;
import java.util.Map;

public class FnConfigurator implements Configurator {

    private final Map<Key, Object> settings = new HashMap<>();

    public FnConfigurator() {
        Fluentness.getApplication().configure(this);
    }

    @Override
    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    @Override
    public <T> T get(Key<T> key) {
        return settings.containsKey(key) ? (T) settings.get(key) : key.getFallback();
    }

    @Override
    public <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }
}