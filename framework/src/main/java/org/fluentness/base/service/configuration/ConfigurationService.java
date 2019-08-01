package org.fluentness.base.service.configuration;

import org.fluentness.base.service.Service;

interface ConfigurationService extends Service {


    <T> boolean has(Setting<T> key);

    <T> T get(Setting<T> key);

    <T> ConfigurationService set(Setting<T> key, T value);

}
