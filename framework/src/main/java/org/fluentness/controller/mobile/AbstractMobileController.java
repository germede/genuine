package org.fluentness.controller.mobile;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.AbstractDesktop;

public abstract class AbstractMobileController<D extends AbstractDesktop> implements Controller {
//
//    protected final D desktop;
//
//    protected AbstractMobileController(Class<D> desktopClass) {
//        D desktop = null;
//        try {
//            desktop = desktopClass.getConstructor(this.getClass()).newInstance(this);
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        this.desktop = desktop;
//    }
//
//    public final D getDesktop() {
//        return desktop;
//    }
}
