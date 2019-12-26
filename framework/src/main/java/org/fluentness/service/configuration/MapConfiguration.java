package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public class MapConfiguration implements Configuration {

    private final Map<Key, Object> settings = new HashMap<>();

    @Override
    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    @Override
    public <T> T get(Key<T> key) {
        return settings.containsKey(key) ? (T) settings.get(key) : key.getFallback();
    }

    @Override
    public <T> Configuration set(Key<T> key, T value) {
        settings.put(key, value);
        return this;
    }
}