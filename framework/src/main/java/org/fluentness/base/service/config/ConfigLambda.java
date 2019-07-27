package org.fluentness.base.service.config;

@FunctionalInterface
public interface ConfigLambda {

    void configure(Config conf);

}
