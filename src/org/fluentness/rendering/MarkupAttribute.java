package org.fluentness.rendering;

import java.util.function.Function;

public interface MarkupAttribute<T> extends MethodFinder, Function<String, T>, Renderable {
    default String key() {
        checkParametersEnabled();
        return parameter(0).getName();
    }

    default void checkParametersEnabled() {
        if ("arg0".equals(parameter(0).getName())) {
            throw new IllegalStateException(
                    "You need to compile with javac -parameters for parameter reflection to work; " +
                    "You also need java 8u60 or newer to use it with lambdas");
        }
    }

    default T value() {
        return apply(key());
    }

    default String render() {
        return key() + "=\"" + value() + "\"";
    }
}