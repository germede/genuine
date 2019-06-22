package org.fluentness.common.generics;

import org.fluentness.flow.task.TaskProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public interface Register<K, V> {

    // keys of map of maps are the classes that implement register, NOT the instances
    Map<Class, Map> mapOfMaps = new HashMap<>();

    default Map<K, V> map() {
        // lazy creator of registers
        if (!mapOfMaps.containsKey(this.getClass())) {
            if (this instanceof TaskProvider) {
                mapOfMaps.put(this.getClass(), new TreeMap());
            } else {
                mapOfMaps.put(this.getClass(), new HashMap());
            }
            if (this instanceof Provider) {
                putAll(((Provider) this).retrieveAll());
            }
        }
        return mapOfMaps.get(this.getClass());
    }

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

    default Map<K, V> getAll() {
        return map();
    }

    default void remove(K key) {
        map().remove(key);
    }
}
