package org.fluentness.service.configurator;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public interface Configurator extends Service {

    Map<Key, Object> settings = new HashMap<>();

    default boolean has(Key key) {
        return settings.containsKey(key);
    }

    default <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    default <T> T getOrDefault(Key<T> key, T fallback) {
        return (T) settings.getOrDefault(key, fallback);
    }

    default <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

}