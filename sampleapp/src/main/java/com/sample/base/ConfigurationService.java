package com.sample.base;

import org.fluentness.base.configuration.Configuration;
import org.fluentness.base.configuration.Environment;
import org.fluentness.base.configuration.Settings;

public class ConfigurationService implements Configuration {

    private Settings settings = new Settings(Environment.DEV)
            .add("app_protocol").dev("http").prod("https")
            .add("app_host").dev("localhost")
            .add("app_port").dev("8000").prod("80")
            .add("log_level").dev("INFO").prod("ERRO")
            .add("log_to_console").dev("true").prod("false")
            .add("compress_styles").dev("false").prod("true");

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public Environment getEnvironment() {
        return Environment.DEV;
    }
}
