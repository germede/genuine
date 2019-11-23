package org.fluentness.service.configurator;

import org.fluentness.service.Service;
import org.fluentness.service.logger.LogLevel;

public interface Configurator extends Service {

    Key<String> authentication_username = new Key<>();
    Key<String> authentication_password = new Key<>();
    Key<LogLevel> logger_level = new Key<>();
    Key<Boolean> logger_console = new Key<>();
    Key<String> logger_file = new Key<>();
    Key<String> mailing_server = new Key<>();
    Key<String> mailing_username = new Key<>();
    Key<String> mailing_password = new Key<>();
    Key<Integer> mailing_port = new Key<>();
    Key<String> persistence_unit = new Key<>();
    Key<Boolean> router_single_page_mode = new Key<>();
    Key<String> router_encoding = new Key<>();
    Key<String> server_context = new Key<>();
    Key<Integer> server_port = new Key<>();

    <T> boolean has(Key key);

    <T> T get(Key<T> key);

    <T> T getOrDefault(Key<T> key, T fallback);
}