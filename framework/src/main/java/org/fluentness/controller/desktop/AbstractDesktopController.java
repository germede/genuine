package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractDesktopController<D extends AbstractDesktop> implements Controller {

    protected final D desktop;

    protected AbstractDesktopController(Class<D> desktopClass) {
        D desktop = null;
        try {
            desktop = desktopClass.getConstructor(this.getClass()).newInstance(this);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        this.desktop = desktop;
    }

    public final D getDesktop() {
        return desktop;
    }
}
