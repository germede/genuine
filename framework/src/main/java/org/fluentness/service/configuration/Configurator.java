package org.fluentness.service.configuration;

@FunctionalInterface
public interface Configurator {

    void configure(Configuration configuration);
}
