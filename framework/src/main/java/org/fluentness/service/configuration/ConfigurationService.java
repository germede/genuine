package org.fluentness.service.configuration;

import org.fluentness.service.Service;
import org.fluentness.service.logger.LogLevel;

public interface ConfigurationService extends Service {

    Key<LogLevel> logger_level = new Key<>();
    Key<Boolean> logger_console = new Key<>();
    Key<String> logger_file = new Key<>();
    Key<String> persistence_unit = new Key<>();
    Key<String> server_context = new Key<>();
    Key<Integer> server_port = new Key<>();


    <T> T get(Key<T> key);

    boolean has(Key key);

    default Environment getEnvironment() {
        String environment = System.getProperty("environment");
        return environment == null || environment.isEmpty() ?
            Environment.DEV :
            Environment.valueOf(environment.toUpperCase());

    }
}