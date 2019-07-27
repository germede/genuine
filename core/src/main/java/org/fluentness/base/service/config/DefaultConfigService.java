package org.fluentness.base.service.config;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.config.BooleanKey.*;
import static org.fluentness.base.service.config.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.StringKey.*;

public class DefaultConfigService implements ConfigService {

    private Map<Key, Object> settings = new HashMap<>();

    public DefaultConfigService() {
        // default settings
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
    public ConfigService within(Environment environment) {
        environment.configure(this);
        return this;
    }

    @Override
    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    @Override
    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }


}