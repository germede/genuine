package org.fluentness.common;

import org.fluentness.rendering.Renderable;

import java.util.function.Function;

public interface NamedValue<T> extends MethodFinder, Function<String, T>, Renderable {
    default String name() {
        checkParametersEnabled();
        return parameter(0).getName();
    }

    default void checkParametersEnabled() {
        if ("arg0".equals(parameter(0).getName())) {
            throw new IllegalStateException("You need to compile with javac -parameters for parameter reflection to work and java 8u60 or newer to use it with lambdas");
        }
    }

    default T value() {
        return apply(name());
    }

    default String render() {
        if (value() == null) {
            return name();
        }
        return name() + "=\"" + value() + "\"";
    }
}