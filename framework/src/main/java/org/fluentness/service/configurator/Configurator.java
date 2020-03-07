package org.fluentness.service.configurator;

import org.fluentness.service.Service;

import java.util.HashMap;
import java.util.Map;

public abstract class Configurator implements Service {

    private final Map<Setting, Object> settings = new HashMap<>();

    public Configurator() {
        configure();
    }

    public final <T> boolean has(Setting<T> setting) {
        return settings.containsKey(setting);
    }

    public final <T> T get(Setting<T> setting) {
        return settings.containsKey(setting) ? (T) settings.get(setting) : setting.getFallback();
    }

    protected final <T> Configurator set(Setting<T> setting, T value) {
        settings.put(setting, value);
        return this;
    }

    protected abstract void configure();

}