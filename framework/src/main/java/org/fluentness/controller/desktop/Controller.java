package org.fluentness.controller.desktop;

public abstract class Controller<D extends View> implements org.fluentness.controller.Controller {

    protected final D desktop;

    protected Controller(Class<D> desktopClass) {
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
