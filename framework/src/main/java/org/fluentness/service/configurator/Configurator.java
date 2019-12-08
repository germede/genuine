package org.fluentness.service.configurator;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

@Singleton
public interface Configurator extends Service {

    boolean has(Key key);

    <T> T get(Key<T> key);

    <T> T getOrDefault(Key<T> key, T fallback);

    <T> void set(Key<T> key, T value);

}