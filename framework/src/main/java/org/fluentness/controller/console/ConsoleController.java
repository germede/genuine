package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public abstract class ConsoleController implements Controller {

    @Override
    public Method[] getActions() {
        return (Method[]) Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(ConsoleAction.class))
                .toArray();
    }

    public String[] getArguments(Method action) {
        return (String[]) Arrays.stream(action.getParameters())
                .filter(parameter -> parameter.isAnnotationPresent(Argument.class))
                .map(Parameter::getName)
                .toArray();
    }

    public String getDescription(Method action) {
        return action.getAnnotation(Argument.class).value();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface ConsoleAction {
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Argument {
        String value();
    }
}
