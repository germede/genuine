package com.sample.service;

import org.fluentness.service.configuration.Environment;
import org.fluentness.service.configuration.AbstractConfigurationService;

public class ConfigurationService extends AbstractConfigurationService {

    @Override
    protected void configure() {
        add("app_protocol").dev("http").prod("https");
        add("app_host").dev("localhost");
        add("app_port").dev("8000").prod("80");
        add("log_level").dev("INFO").prod("ERRO");
        add("log_to_console").dev("true").prod("false");
        add("persistence_unit").dev("bookLibraryPU").prod("bookLibraryPU");
        add("compress_styles").dev("false").prod("true");
    }

    @Override
    public Environment getDefaultEnvironment() {
        return Environment.DEV;
    }

    @Override
    public Environment getCurrentEnvironment() {
        return Environment.DEV;
    }
}
