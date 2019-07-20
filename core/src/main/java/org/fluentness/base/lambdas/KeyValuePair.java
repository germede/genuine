package org.fluentness.base.lambdas;

import org.fluentness.Fluentness;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface KeyValuePair<T> extends MethodFinder, Function<String, T> {

    Map<String, String> keyCache = new HashMap<>();

    default String getKey() {
        String lambdaClassName = this.getClass().getName();
        if (keyCache.containsKey(lambdaClassName)) {
            return keyCache.get(lambdaClassName);
        }
        if ("arg0".equals(parameter().getName())) {
            Fluentness.base.getLogger().warning("You need to compile with javac -parameters for parameter reflection");
        }
        String key = parameter().getName();
        keyCache.put(lambdaClassName, key);
        return key;
    }

    default T getValue() {
        return apply(getKey());
    }
}