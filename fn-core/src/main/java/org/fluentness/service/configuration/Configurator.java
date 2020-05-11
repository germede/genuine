package org.fluentness.service.configuration;

@FunctionalInterface
public interface Configurator {
    Configuration configure(Configuration configuration);
}
