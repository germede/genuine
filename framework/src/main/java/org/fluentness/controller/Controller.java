package org.fluentness.controller;

import org.fluentness.ApplicationComponent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface Controller<V extends View> extends ApplicationComponent {

    default Method[] getActions() {
        return Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.isAnnotationPresent(getActionClass()))
            .toArray(Method[]::new);
    }

    Class<? extends Annotation> getActionClass();

}
