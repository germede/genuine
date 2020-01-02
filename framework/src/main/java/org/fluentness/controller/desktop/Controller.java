package org.fluentness.controller.desktop;

import java.lang.annotation.*;

public abstract class Controller<D extends View> implements org.fluentness.controller.Controller {

    protected final D desktop;

    protected Controller() {
        try {
            this.desktop = ((Class<D>) Class.forName(getClass().getCanonicalName().replace("Controller", ""))).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
            this.desktop = null;
        }
    }

    public final D getDesktop() {
        return desktop;
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String selector();

        Event event() default Event.CLICK;

    }

    protected enum Event {
        CLICK
    }
}
