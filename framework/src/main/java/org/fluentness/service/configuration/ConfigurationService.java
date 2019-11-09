package org.fluentness.service.configuration;

import org.fluentness.service.Service;
import org.fluentness.service.logging.LogLevel;

public interface ConfigurationService extends Service {

    Key<String> authentication_username = new Key<>();
    Key<String> authentication_password = new Key<>();
    Key<LogLevel> logger_level = new Key<>();
    Key<Boolean> logger_console = new Key<>();
    Key<String> logger_file = new Key<>();
    Key<String> persistence_unit = new Key<>();
    Key<String> router_encoding = new Key<>();
    Key<String> server_context = new Key<>();
    Key<Integer> server_port = new Key<>();


    <T> T get(Key<T> key);

    boolean has(Key key);
}