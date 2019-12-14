package org.fluentness.configuration;

import org.fluentness.Fluentness;

import java.util.HashMap;
import java.util.Map;

public class FnConfiguration implements Configuration {

    private final Map<Key, Object> settings = new HashMap<>();

    public FnConfiguration() {
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