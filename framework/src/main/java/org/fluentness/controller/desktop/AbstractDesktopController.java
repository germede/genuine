package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDesktopController implements Controller<DesktopAction> {

    @Override
    public List<DesktopAction> getActions() {
        List<DesktopAction> result = new LinkedList<>();
        Arrays.stream(getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .forEach(method -> result.add(
                new DesktopAction(
                    method.getAnnotation(Action.class).listener(),
                    method.getAnnotation(Action.class).id(),
                    method
                ))
            );
        return result;
    }


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String id();
        Class<? extends EventListener> listener();

    }

    public abstract DesktopView getDesktopView();
}
