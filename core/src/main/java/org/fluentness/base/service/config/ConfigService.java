package org.fluentness.base.service.config;

import org.fluentness.base.service.Service;

public interface ConfigService extends Service {

    @Override
    default int getDefinitionPriority() {
        return 0;
    }

    ConfigService within(Environment environment);

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> void set(Key<T> key, T value);

}
