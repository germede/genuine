package com.sample;

import org.fluentness.base.provider.configuration.MapConfiguration;

public class Configuration extends MapConfiguration {

    @Environment()
    public final String test = "test";

}
