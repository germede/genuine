package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class AbstractConsoleController implements Controller {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }

}
