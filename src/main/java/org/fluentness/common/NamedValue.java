package org.fluentness.common;

import org.fluentness.register.NamedValueRegister;
import org.fluentness.rendering.Renderable;

import java.util.function.Function;

public interface NamedValue<T> extends MethodFinder, Function<String, T>, Renderable {
    default String name() {
        String lambdaClassName = this.getClass().getName();
        if (NamedValueRegister.existsName(lambdaClassName)) {
            return NamedValueRegister.getName(lambdaClassName);
        }
        checkParametersEnabled();
        String name = parameter().getName();
        NamedValueRegister.putName(lambdaClassName, name);
        return name;
    }

    default void checkParametersEnabled() {
        if ("arg0".equals(parameter().getName())) {
            throw new IllegalStateException("You need to compile with javac -parameters for parameter reflection to work and java 8u60 or newer to use it with lambdas");
        }
    }

    default T value() {
        return apply(name());
    }

    default String render() {
        return name() + "=\"" + value() + "\"";
    }
}