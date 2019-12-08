package org.fluentness.service.configurator;

import java.util.HashMap;
import java.util.Map;

public class MapConfigurator implements Configurator {

    private final Map<Key, Object> settings = new HashMap<>();

    @Override
    public boolean has(Key key) {
        return settings.containsKey(key);
    }

    @Override
    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public <T> T getOrDefault(Key<T> key, T fallback) {
        return (T) settings.getOrDefault(key, fallback);
    }

    @Override
    public <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }
}