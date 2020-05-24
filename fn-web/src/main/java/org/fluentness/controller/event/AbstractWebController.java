package org.fluentness.controller.event;

import org.fluentness.controller.WebController;
import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.HtmlComponent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebController<W extends AbstractWebView> extends AbstractEventController<W> implements WebController {

    private final String path;
    private final Map<String, JavaScriptEvent> events = new HashMap<>();

    public AbstractWebController(W view, String path) {
        super(view);
        this.path = path;
    }

    public final Collection<JavaScriptEvent> getEvents() {
        return events.values();
    }

    public final Object main(String eventId) {
        if (events.containsKey(eventId)) {
            JavaScriptCommand.clear();
            events.get(eventId).getEvent().handle();
            return JavaScriptCommand.getCommands();
        }
        return view;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    protected void onClick(Clickable clickable, OnClickEvent onClickEvent) {
        addEvent((HtmlComponent) clickable, onClickEvent, "click");
    }

    private void addEvent(HtmlComponent clickable, Event event, String eventName) {
        int componentId = clickable.getId();
        String eventId = componentId + eventName;
        events.put(eventId, new JavaScriptEvent(componentId, eventName, eventId, event));
    }

}
