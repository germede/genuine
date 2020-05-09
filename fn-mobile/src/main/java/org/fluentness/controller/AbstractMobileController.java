package org.fluentness.controller;

import org.fluentness.view.AbstractMobileView;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMobileController implements Controller {

    private static final Map<Class, Object> viewInstances = new HashMap<>();
    protected final AbstractMobileView view;

    public final AbstractMobileView getView() {
        return view;
    }

    public AbstractMobileController(Class<? extends AbstractMobileView> viewClass) {
        if (!viewInstances.containsKey(viewClass)) {
            try {
                viewInstances.put(viewClass, viewClass.getConstructors()[0].newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        view = (AbstractMobileView) viewInstances.get(viewClass);
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
