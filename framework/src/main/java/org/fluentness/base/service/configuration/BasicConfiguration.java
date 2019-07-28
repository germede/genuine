package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.StdLogLevel;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.configuration.Key.Boolean.*;
import static org.fluentness.base.service.configuration.Key.Integer.APP_PORT;
import static org.fluentness.base.service.configuration.Key.LogLevel.LOG_LEVEL;
import static org.fluentness.base.service.configuration.Key.String.*;

public class BasicConfiguration implements Configuration {

    private Map<Key, Object> settings = new HashMap<>();

    public BasicConfiguration(ConfigurationLambda custom) {
        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, StdLogLevel.INFO);
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);

        // custom settings
        custom.configure(this);
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
    public <T> Configuration set(Key<T> key, T value) {
        settings.put(key, value);
        return this;
    }


}