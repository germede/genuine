package org.fluentness.service.configuration;

public interface Configuration {

    <T> boolean has(Setting<T> setting);

    <T> T get(Setting<T> setting);
}