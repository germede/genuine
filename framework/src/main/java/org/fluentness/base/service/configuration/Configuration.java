package org.fluentness.base.service.configuration;

import org.fluentness.base.service.Service;

public interface Configuration extends Service {

    @Override
    default int getDefinitionPriority() {
        return 0;
    }

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> Configuration set(Key<T> key, T value);

}
