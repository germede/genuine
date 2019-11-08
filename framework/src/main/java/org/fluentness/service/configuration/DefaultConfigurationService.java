package org.fluentness.service.configuration;

import org.fluentness.Application;

import static org.fluentness.service.logger.LogLevel.DEBUG;

public class DefaultConfigurationService extends AbstractConfigurationService {

    @Override
    public void configure(Application.Environment environment) {
        set(server_port, 8000);
        set(logger_level, DEBUG);
        set(logger_console, true);
    }

}