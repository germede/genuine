package org.fluentness.service.configurator;

import org.fluentness.service.Service;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.REPLACEABLE;

@ServiceType(REPLACEABLE)
public interface Configurator extends Service {

    Map<String, String> tet = new HashMap<>();

    boolean has(Key key);

    <T> T get(Key<T> key);

    <T> T getOrDefault(Key<T> key, T fallback);

}