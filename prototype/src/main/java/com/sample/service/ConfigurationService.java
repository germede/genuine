package com.sample.service;

import org.fluentness.service.configuration.AbstractConfigurationService;
import org.fluentness.service.configuration.Environment;
import org.fluentness.service.logger.LogLevel;

public class ConfigurationService extends AbstractConfigurationService {

    @Override
    protected void configure(Environment environment) {
        if (environment.equals(Environment.DEV)) {
            set(server_port, 8000);
            set(logger_level, LogLevel.DEBUG);
            set(logger_console, true);
            set(persistence_unit, "bookLibraryPU");
        }

        if (environment.equals(Environment.PROD)) {
            set(server_port, 80);
            set(logger_level, LogLevel.ERROR);
            set(logger_console, true);
        }
    }

}
