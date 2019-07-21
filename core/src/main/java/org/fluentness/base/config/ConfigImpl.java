package org.fluentness.base.config;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.config.BooleanKey.*;
import static org.fluentness.base.config.IntegerKey.APP_PORT;
import static org.fluentness.base.config.StringKey.*;

public class ConfigImpl implements Config {

    private Map<Key, Object> settings = new HashMap<>();

    @Override
    public void initialize() {
        // default config
        set(APP_PROTOCOL, "http");
        set(APP_HOST, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, "ALL");
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }

    @Override
    public void clear() {
        settings.clear();
    }

    @Override
    public <T>T get(Key<T> key) {
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
