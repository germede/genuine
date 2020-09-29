package org.fluentness.controller;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public interface Controller {

    default Map<String, Method> getActionMap() {
        return Arrays.stream(this.getClass().getMethods()).collect(Collectors.toMap(Method::getName, method -> method));
    }

    default Method[] getActions() {
        return this.getClass().getMethods();
    }
}
