package org.fluentness.controller;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public interface Controller {

    static <T extends Controller> List<Method> getAllActions(List<T> controllers) {
        List<Method> result = new LinkedList<>();
        controllers.forEach(t -> result.addAll(Arrays.asList(t.getActions())));
        return result;
    }

    Method[] getActions();
}
