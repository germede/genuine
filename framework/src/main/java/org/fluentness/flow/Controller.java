package org.fluentness.flow;

import org.fluentness.flow.console.ConsoleAction;

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
