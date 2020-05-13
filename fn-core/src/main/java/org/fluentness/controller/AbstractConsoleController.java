package org.fluentness.controller;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConsoleController implements ActionController {

    public static final Map<String, Method> nameActionMap = new HashMap<>();

    public AbstractConsoleController() {
        Arrays.stream(getActions()).forEach(action -> nameActionMap.put(action.getName(), action));
    }

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }


}
