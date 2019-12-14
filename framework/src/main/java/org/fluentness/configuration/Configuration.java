package org.fluentness.configuration;

public interface Configuration {

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> void set(Key<T> key, T value);

}