package org.fluentness.controller.console;

import org.fluentness.controller.Controller;

import java.lang.reflect.Method;

public class ConsoleAction implements Controller.Action {

    private String description;
    private String category;
    private Method function;

    ConsoleAction(String description, String category, Method function) {
        this.description = description;
        this.category = category;
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public Method getMethod() {
        return function;
    }
}
