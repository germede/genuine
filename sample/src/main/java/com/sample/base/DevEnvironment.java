package com.sample.base;

import org.fluentness.base.service.config.ConfigService;
import org.fluentness.base.service.config.Environment;
import org.fluentness.base.service.config.IntegerKey;

public class DevEnvironment implements Environment {

    @Override
    public void configure(ConfigService config) {
        config.set(IntegerKey.APP_PORT, 8080);
    }
}
