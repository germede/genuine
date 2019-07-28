package org.fluentness.base.service.configuration;

@FunctionalInterface
public interface ConfigurationLambda {

    void configure(Configuration conf);

}
