package org.fluentness.service.configuration;

import org.fluentness.service.Service;

public interface ConfigurationService extends Service {

    String get(String key);

    boolean is(String key);

    boolean has(String key);

    Environment getEnvironment();
}