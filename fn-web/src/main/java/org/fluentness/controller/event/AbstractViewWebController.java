package org.fluentness.controller.event;

import org.fluentness.controller.WebController;
import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.HtmlComponent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractViewWebController<W extends AbstractWebView> extends AbstractViewController<W> implements WebController {

    private final String path;
    private final Map<String, JavaScriptEvent> events = new HashMap<>();

    public AbstractViewWebController(W view, String path) {
        super(view);
        this.path = path;
    }

    public final Collection<JavaScriptEvent> getEvents() {
        return events.values();
    }

    public final Object main(String eventId) {
        if (events.containsKey(eventId)) {
            JavaScriptCommand.clear();
            events.get(eventId).getHandler().handle();
            return JavaScriptCommand.getCommands();
        }
        return view;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    protected void onClick(Clickable clickable, Handler handler) {
        addEvent((HtmlComponent) clickable, "click", handler);
    }

    private void addEvent(HtmlComponent clickable, String eventType, Handler handler) {
        JavaScriptEvent event = new JavaScriptEvent(clickable.getXpath(), clickable.getId(), eventType, handler);
        events.put(event.getId(), event);
    }

}
