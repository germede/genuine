package org.fluentness.service.configuration;

import org.fluentness.service.Service;

public interface ConfigurationService extends Service {

    Settings getSettings();

    Environment getEnvironment();

}