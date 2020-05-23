package org.fluentness.controller.event;

public class JavaScriptEvent {

    private final int id;
    private final String event;
    private final String eventId;

    public JavaScriptEvent(int id, String event, String eventId){
        this.id = id;
        this.event = event;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getEventId() {
        return eventId;
    }
}
