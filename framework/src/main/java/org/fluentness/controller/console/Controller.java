package org.fluentness.controller.console;

import java.lang.annotation.*;

public abstract class Controller implements org.fluentness.controller.Controller {

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
