package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationImpl implements Configuration {

    private final Map<Setting, Object> settings = new HashMap<>();

    @Override
    public final <T> boolean has(Setting<T> setting) {
        return settings.containsKey(setting);
    }

    @Override
    public final <T> T get(Setting<T> setting) {
        return settings.containsKey(setting) ? (T) settings.get(setting) : setting.getFallback();
    }

    @Override
    public final <T> ConfigurationImpl set(Setting<T> setting, T value) {
        settings.put(setting, value);
        return this;
    }

}