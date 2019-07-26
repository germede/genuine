package com.sample.base;

import org.fluentness.base.common.environment.Environment;

public class DevEnvironment extends Environment {

    @Override
    public void initialize() {
        setDefaultSettings();
    }
}
