package org.fluentness.controller;

import org.fluentness.controller.Controller;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMobileController implements Controller {

    private static final Map<Class, Object> viewInstances = new HashMap<>();
    protected final MobileView view;

    public final MobileView getView() {
        return view;
    }

    public AbstractMobileController(Class<? extends MobileView> viewClass) {
        if (!viewInstances.containsKey(viewClass)) {
            try {
                viewInstances.put(viewClass, viewClass.getConstructors()[0].newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        view = (MobileView) viewInstances.get(viewClass);
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String selector();
    }


}
