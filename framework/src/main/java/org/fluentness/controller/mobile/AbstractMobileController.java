package org.fluentness.controller.mobile;

import org.fluentness.controller.Controller;

import java.lang.reflect.Method;

public abstract class AbstractMobileController implements Controller {

    @Override
    public Method[] getActions() {
        return new Method[0];
    }
}
