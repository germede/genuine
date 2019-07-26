package org.fluentness.base.service.config;

import org.fluentness.base.service.Service;

public interface Config extends Service {
    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> void set(Key<T> key, T value);
}
