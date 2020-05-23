package org.fluentness.controller.event;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.controller.WebController;
import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.HtmlAttribute;
import org.fluentness.view.component.HtmlComponent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEventWebController<W extends AbstractWebView> extends AbstractEventController<W> implements WebController {

    private final String path;
    private final Map<String, JavaScriptEvent> events = new HashMap<>();

    public AbstractEventWebController(W view, String path) {
        super(view);
        this.path = path;
    }

    public final Collection<JavaScriptEvent> getEvents() {
        return events.values();
    }

    public final W main(HttpServletRequest request) {


        return view;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    protected void onClick(Clickable clickable, OnClickEvent onClickEvent) {
        String event = "click";
        int componentId = ((HtmlComponent) clickable).getId();
        ((HtmlComponent) clickable).addAttribute(HtmlAttribute.ID + String.valueOf(componentId));
        String eventId = componentId + event;
        events.put(eventId, new JavaScriptEvent(componentId, event, eventId));
    }

}
