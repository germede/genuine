package org.fluentness.controller.action;

import org.fluentness.controller.Controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class AbstractActionController implements Controller {

    private final Class<? extends Annotation> actionClass;

    public AbstractActionController(Class<? extends Annotation> actionClass) {
        this.actionClass = actionClass;
    }

    public final Method[] getActions() {
        return Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.isAnnotationPresent(actionClass))
            .toArray(Method[]::new);
    }

}
