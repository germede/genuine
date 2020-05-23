package org.fluentness.controller.event;

public class JavaScriptEvent {

    private final int id;
    private final String eventName;
    private final String eventId;
    private final Event event;

    public JavaScriptEvent(int id, String eventName, String eventId, Event event) {
        this.id = id;
        this.eventName = eventName;
        this.eventId = eventId;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public Event getEvent() {
        return event;
    }
}
