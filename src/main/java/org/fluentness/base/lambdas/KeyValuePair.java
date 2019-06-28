package org.fluentness.base.lambdas;

import java.util.function.Function;

public interface KeyValuePair<T> extends MethodFinder, Function<String, T> {

    default String getKey() {
        String lambdaClassName = this.getClass().getName();
        if (KeyValuePairKeyRegister.call.containsKey(lambdaClassName)) {
            return KeyValuePairKeyRegister.call.get(lambdaClassName);
        }
        checkParametersEnabled();
        String key = parameter().getName();
        KeyValuePairKeyRegister.call.put(lambdaClassName, key);
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