package org.fluentness.base.generics;

import java.util.HashMap;
import java.util.Map;

// Force register to be singleton
public interface Register<SINGLETON extends Enum, K, V> {

    Map<Class<? extends Enum>, Map> singletonRegisterMap = new HashMap<>();

    default Map<K, V> map() {
        if (singletonRegisterMap.get(this.getClass()) == null) {
            singletonRegisterMap.put((Class<? extends Enum>) this.getClass(), new HashMap());
        }
        return singletonRegisterMap.get(this.getClass());
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
