package org.fluentness.flow.controller;

import org.fluentness.flow.controller.console.ConsoleAction;

import java.lang.reflect.Method;
import java.util.Arrays;

public interface Controller {

    default String[] getConsoleActions() {
        return (String[]) Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(ConsoleAction.class))
                .map(Method::getName)
                .toArray();
    }

}
