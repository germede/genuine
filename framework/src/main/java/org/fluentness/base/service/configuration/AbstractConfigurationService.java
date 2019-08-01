package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.FluentnessLogLevel;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfigurationService implements ConfigurationService {


    protected Setting<String> app_protocol = new Setting<>("http");
    protected Setting<String> app_hostname = new Setting<>("localhost");
    protected Setting<Integer> app_port = new Setting<>(8000);
    protected Setting<FluentnessLogLevel> log_level = new Setting<>(FluentnessLogLevel.INFO);
    protected Setting<Boolean> enable_log_to_console = new Setting<>(true);
    protected Setting<Boolean> enable_log_to_file = new Setting<>(false);
    protected Setting<Boolean> enable_cache = new Setting<>(true);
    protected Setting<Boolean> enable_style_minify = new Setting<>(true);


    private Map<Setting, Object> settings = new HashMap<>();

    {
        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, FluentnessLogLevel.INFO);
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);

        // custom settings
        configure();
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
    public <T> ConfigurationService set(Setting<T> key, T value) {
        settings.put(key, value);
        return this;
    }

    protected abstract void configure();
}