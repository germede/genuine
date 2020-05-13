package org.fluentness.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface ActionController extends Controller {

    default Method[] getActions() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(getActionClass()))
            .toArray(Method[]::new);
    }

    Class<? extends Annotation> getActionClass();

}
