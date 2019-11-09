package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractConsoleController implements Controller {

    public List<ConsoleAction> getActions() {
        List<ConsoleAction> result = new LinkedList<>();
        Arrays.stream(getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .forEach(method -> result.add(
                new ConsoleAction(
                    method.getAnnotation(Action.class).description(),
                    method.getAnnotation(Action.class).category(),
                    method
                ))
            );
        return result;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }

}
