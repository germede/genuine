package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public class MapConfiguration implements Configuration {

    private final Map<Setting, Object> settings = new HashMap<>();

    @Override
    public <T> boolean has(Setting<T> setting) {
        return settings.containsKey(setting);
    }

    @Override
    public <T> T get(Setting<T> setting) {
        return settings.containsKey(setting) ? (T) settings.get(setting) : setting.getFallback();
    }

    @Override
    public <T> Configuration set(Setting<T> setting, T value) {
        settings.put(setting, value);
        return this;
    }
}