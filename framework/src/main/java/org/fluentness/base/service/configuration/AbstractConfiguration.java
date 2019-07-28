package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.FluentnessLogLevel;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfiguration implements Configuration {

    private Map<Setting, Object> settings = new HashMap<>();

    public AbstractConfiguration() {
        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, FluentnessLogLevel.INFO);
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }

    @Override
    public <T> boolean has(Setting<T> key) {
        return settings.containsKey(key);
    }

    @Override
    public <T> T get(Setting<T> key) {
        return (T) settings.get(key);
    }

    @Override
    public <T> Configuration set(Setting<T> key, T value) {
        settings.put(key, value);
        return this;
    }

    public abstract void configure();
}