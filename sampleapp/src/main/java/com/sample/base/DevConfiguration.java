package com.sample.base;

import org.fluentness.base.service.configuration.AbstractConfiguration;

public class DevConfiguration extends AbstractConfiguration {

    @Override
    public void configure() {
        set(PERSISTENCE_UNIT, "songLibraryPU");
    }

}
