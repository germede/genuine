package org.fluentness.base.service.config;

import org.fluentness.base.service.Service;

public interface Config extends Service {

    @Override
    default int getDefinitionPriority() {
        return 0;
    }

    <T> boolean has(Key<T> key);

    boolean is(Key<Boolean> key);

    <T> T get(Key<T> key);

    <T> Config set(Key<T> key, T value);

}
