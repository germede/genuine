package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.*;

public abstract class AbstractConsoleController implements Controller {

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }


}
