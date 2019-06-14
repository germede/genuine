package org.fluentness.base.generics;

import java.util.HashMap;
import java.util.Map;

public interface Register<K, V> {
    Map register = new HashMap<>();

    default boolean containsValue(V value) {
        return register.containsKey(value);
    }

    default boolean containsKey(K key) {
        return register.containsKey(key);
    }

    default void put(K key, V value) {
        register.put(key, value);
    }

    default V get(K key) {
        return (V) register.get(key);
    }

    default void remove(K key) {
        register.remove(key);
    }
}
