package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

import java.lang.reflect.Method;

public abstract class AbstractDesktopController implements Controller {

    @Override
    public Method[] getActions() {
        return new Method[0];
    }
}
