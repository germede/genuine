package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class AbstractConsoleController implements Controller {

    public String[] getActions() {
        return (String[]) Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Description.class))
                .map(Method::getName)
                .toArray();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Description {
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Argument {
        String value();
    }
}
