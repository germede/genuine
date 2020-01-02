package org.fluentness.service.configuration;

public class Setting<T> {

    private T fallback;

    public Setting() {
    }

    public Setting(T fallback) {
        this.fallback = fallback;
    }

    public T getFallback() {
        return fallback;
    }
}
