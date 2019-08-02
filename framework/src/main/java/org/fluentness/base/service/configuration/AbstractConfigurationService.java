package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.LogLevel;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfigurationService implements ConfigurationService {

    public static final Setting<String> APP_PROTOCOL = new Setting<>();
    public static final Setting<String> APP_HOSTNAME = new Setting<>();
    public static final Setting<Integer> APP_PORT = new Setting<>();
    public static final Setting<String> PERSISTENCE_UNIT = new Setting<>();
    public static final Setting<LogLevel> LOG_LEVEL = new Setting<>();
    public static final Setting<Boolean> LOG_TO_CONSOLE = new Setting<>();
    public static final Setting<String> LOG_TO_FILE = new Setting<>();
    public static final Setting<String> VIEW_CACHE_DIRECTORY = new Setting<>();
    public static final Setting<Boolean> COMPRESS_STYLES = new Setting<>();

    private Map<Setting, Object> settings = new HashMap<>();

    public final String test = "asdf";

    public AbstractConfigurationService() {
        // default settings
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, LogLevel.INFO);
        set(LOG_TO_CONSOLE, true);
        set(COMPRESS_STYLES, true);

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

    protected <T> AbstractConfigurationService set(Setting<T> key, T value) {
        settings.put(key, value);
        return this;
    }

    protected abstract void configure();
}