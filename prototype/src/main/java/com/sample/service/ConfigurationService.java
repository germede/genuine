package com.sample.service;

import org.fluentness.Application;
import org.fluentness.service.configuration.AbstractConfigurationService;
import org.fluentness.service.logging.LogLevel;

public class ConfigurationService extends AbstractConfigurationService {

    @Override
    protected void configure(Application.Environment environment) {
        if (environment.equals(Application.Environment.DEV)) {
            set(server_port, 8000);
            set(logger_level, LogLevel.NONE);
            set(logger_console, true);
            set(persistence_unit, "bookLibraryPU");
            set(authentication_username, "admin");
            set(authentication_password, "admin");
        }

        if (environment.equals(Application.Environment.PROD)) {
            set(server_port, 80);
            set(logger_level, LogLevel.ERROR);
            set(logger_console, true);
        }
    }

}
