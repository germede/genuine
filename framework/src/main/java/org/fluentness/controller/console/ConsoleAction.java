package org.fluentness.controller.console;

import org.fluentness.controller.Action;

import java.lang.reflect.Method;

public class ConsoleAction implements Action {

    private String description;
    private String category;
    private Method method;

    ConsoleAction(String description, String category, Method method) {
        this.description = description;
        this.category = category;
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Method getMethod() {
        return method;
    }
}
