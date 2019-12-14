package org.fluentness.service.configurator;

public class Key<T> {

    private T fallback;

    public Key() {
    }

    public Key(T fallback) {
        this.fallback = fallback;
    }

    public T getFallback() {
        return fallback;
    }
}
