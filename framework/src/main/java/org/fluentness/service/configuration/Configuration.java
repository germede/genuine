package org.fluentness.service.configuration;

import org.fluentness.service.Service;

public interface Configuration extends Service {

    <T> boolean has(Setting<T> setting);

    <T> T get(Setting<T> setting);

    <T> Configuration set(Setting<T> setting, T value);
}