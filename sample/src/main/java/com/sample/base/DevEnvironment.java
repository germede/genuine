package com.sample.base;

import org.fluentness.base.service.config.ConfigService;
import org.fluentness.base.service.config.Environment;
import org.fluentness.base.service.config.StringKey;

public class DevEnvironment extends Environment {

    @Override
    public void configure(ConfigService config) {
        config.set(StringKey.PERSISTENCE_UNIT, "songLibraryPU");
    }
}
