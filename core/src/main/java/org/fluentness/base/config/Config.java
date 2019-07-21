package org.fluentness.base.config;

public interface Config {
    void initialize();

    void clear();

    <T>T get(Key<T> key);

    <T> void set(Key<T> key, T value);

    <T> boolean has(Key<T> key);
}
