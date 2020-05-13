package org.fluentness.controller;

import org.fluentness.Application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface Controller extends Application.Component {

    default Method[] getActions() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(getActionClass()))
            .toArray(Method[]::new);
    }

    Class<? extends Annotation> getActionClass();

}
