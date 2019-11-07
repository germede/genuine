package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfigurationService implements ConfigurationService {

    private final Map<Key, Object> settings = new HashMap<>();

    public AbstractConfigurationService() {
        configure(getEnvironment());
    }

    @Override
    public final <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public final boolean has(Key key) {
        return settings.containsKey(key);
    }

    protected final <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

    protected abstract void configure(Environment environment);
}