package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

import java.lang.reflect.Method;

public class DesktopAction implements Controller.Action {

    private DesktopEvent trigger;
    private String on;
    private Method method;

    DesktopAction(DesktopEvent trigger, String on, Method method) {
        this.trigger = trigger;
        this.on = on;
        this.method = method;
    }

    public DesktopEvent getTrigger() {
        return trigger;
    }

    public String getOn() {
        return on;
    }

    @Override
    public Method getMethod() {
        return method;
    }
}
