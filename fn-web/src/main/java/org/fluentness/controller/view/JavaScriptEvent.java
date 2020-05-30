package org.fluentness.controller.view;

import org.fluentness.controller.event.Handler;

public class JavaScriptEvent {

    private final String id;
    private final String componentXpath;
    private final String eventType;
    private final Handler handler;

    public JavaScriptEvent(String componentXpath, int componentId, String eventType, Handler handler) {
        this.id = componentId + eventType;
        this.componentXpath = componentXpath;
        this.eventType = eventType;
        this.handler = handler;
    }

    public String getId() {
        return id;
    }

    public String getComponentXpath() {
        return componentXpath;
    }

    public String getEventType() {
        return eventType;
    }

    public Handler getHandler() {
        return handler;
    }
}
