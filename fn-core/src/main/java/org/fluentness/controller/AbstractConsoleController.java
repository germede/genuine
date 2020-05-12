package org.fluentness.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConsoleController implements Controller {

    public static final Map<String, Method> nameActionMap = new HashMap<>();

    public AbstractConsoleController() {
        Arrays.stream(getActions()).forEach(action -> nameActionMap.put(action.getName(), action));
    }

    public Method[] getActions() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
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
