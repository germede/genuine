package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConsoleController implements Controller {

    public static final Map<String, Method> nameActionMap = new HashMap<>();

    public AbstractConsoleController() {
        Arrays.stream(getActions()).forEach(action -> nameActionMap.put(action.getName(), action));
    }

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
