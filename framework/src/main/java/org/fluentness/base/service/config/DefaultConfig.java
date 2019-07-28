package org.fluentness.base.service.config;

import org.apache.log4j.Level;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.config.Key.BooleanKey.*;
import static org.fluentness.base.service.config.Key.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.Key.LevelKey.LOG_LEVEL;
import static org.fluentness.base.service.config.Key.StringKey.APP_HOSTNAME;
import static org.fluentness.base.service.config.Key.StringKey.APP_PROTOCOL;

public class DefaultConfig implements Config {

    private Map<Key, Object> settings = new HashMap<>();

    public DefaultConfig(ConfigLambda configLambda) {
        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, Level.ALL);
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);

        // custom settings
        configLambda.configure(this);
    }

    @Override
    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    @Override
    public boolean is(Key<Boolean> key) {
        return has(key) ? get(key) : false;
    }

    @Override
    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public <T> Config set(Key<T> key, T value) {
        settings.put(key, value);
        return this;
    }


}