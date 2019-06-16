package org.fluentness.common.lambdas;

import java.util.function.Function;

public interface KeyValuePair<T> extends MethodFinder, Function<String, T> {
    default String getKey() {
        String lambdaClassName = this.getClass().getName();
        if (KeyValuePairKeyRegister.INSTANCE.containsKey(lambdaClassName)) {
            return KeyValuePairKeyRegister.INSTANCE.get(lambdaClassName);
        }
        checkParametersEnabled();
        String key = parameter().getName();
        KeyValuePairKeyRegister.INSTANCE.put(lambdaClassName, key);
        return key;
    }

    default void checkParametersEnabled() {
        if ("arg0".equals(parameter().getName())) {
            throw new IllegalStateException("You need to compile with javac -parameters for parameter reflection to work and java 8u60 or newer to use it with lambdas");
        }
    }

    default T getValue() {
        return apply(getKey());
    }
}