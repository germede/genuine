package org.fluentness.controller.desktop;

import java.lang.reflect.Method;
import java.util.EventListener;

public class DesktopAction {

    private Class<? extends EventListener> listener;
    private String id;
    private Method method;

    public DesktopAction(Class<? extends EventListener> listener, String id, Method method) {
        this.listener = listener;
        this.id = id;
        this.method = method;
    }

    public Class<? extends EventListener> getListener() {
        return listener;
    }

    public String getId() {
        return id;
    }

    public Method getMethod() {
        return method;
    }
}
