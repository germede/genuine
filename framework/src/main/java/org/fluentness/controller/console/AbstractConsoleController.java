package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class AbstractConsoleController implements Controller {

    @Override
    public Method[] getActions() {
        return Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Action.class))
                .toArray(Method[]::new);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }

}
