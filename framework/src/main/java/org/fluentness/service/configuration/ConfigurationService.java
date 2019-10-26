package org.fluentness.service.configuration;

import org.fluentness.service.Service;

public interface ConfigurationService extends Service {

    Environment getDefaultEnvironment();

    Environment getCurrentEnvironment();

    String get(String key);

    boolean is(String key);

    boolean has(String key);
}