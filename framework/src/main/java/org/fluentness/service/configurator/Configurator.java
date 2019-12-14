package org.fluentness.service.configurator;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

@Singleton
public interface Configurator extends Service {

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> void set(Key<T> key, T value);

}