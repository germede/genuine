package org.fluentness.base.config;

import java.util.HashMap;
import java.util.Map;

public class DefaultConfig implements Config {

    private Map<Key, Object> settings = new HashMap<>();

    @Override
    public void initialize() {
        setDefaultSettings();
    }

    @Override
    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

    @Override
    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }
}
