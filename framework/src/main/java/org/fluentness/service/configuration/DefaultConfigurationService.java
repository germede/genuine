package org.fluentness.service.configuration;

import static org.fluentness.service.logger.LogLevel.DEBUG;

public class DefaultConfigurationService extends AbstractConfigurationService {

    @Override
    public void configure(Environment environment) {
        set(server_port, 8000);
        set(logger_level, DEBUG);
        set(logger_console, true);
    }

}