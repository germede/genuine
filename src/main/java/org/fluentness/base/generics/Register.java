package org.fluentness.base.generics;

import java.util.HashMap;
import java.util.Map;

public interface Register<K, V> {
    Map<String, Map> mapOfMaps = new HashMap<>();

    default Map<K,V> map() {
        Map test = mapOfMaps;
        if (!mapOfMaps.containsKey(this.getClass().getCanonicalName())) {
            mapOfMaps.put(this.getClass().getCanonicalName(),new HashMap<K,V>());
            if (this instanceof Producer) {
                putAll(((Producer) this).retrieveAll());
            }
        }
        return mapOfMaps.get(this.getClass().getCanonicalName());
    };

    default boolean containsValue(V value) {
        return map().containsKey(value);
    }

    default boolean containsKey(K key) {
        return map().containsKey(key);
    }

    default void put(K key, V value) {
        map().put(key, value);
    }

    default void putAll(Map<K, V> mapToPut) {
        map().putAll(mapToPut);
    }

    default V get(K key) {
        return map().get(key);
    }

    default K getKeyForValue(V value) {
        for (Object object : map().entrySet()) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) object;
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    default Map<K,V> getAll() {
        return map();
    }

    default void remove(K key) {
        map().remove(key);
    }
}
