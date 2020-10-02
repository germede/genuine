package org.fluentness.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class WebController<W extends WebView> extends ViewController<W> {

    private final String path;
    private final Map<String, JavaScriptEvent> events = new HashMap<>();

    public WebController(W view, String path) {
        super(view);
        this.path = path;
        WebView.navigation.addSectionFor(this);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {
        String path();

        String method() default GET;
    }

    public final Object main(String eventId, HttpServletRequest request) {
        // dynamic ajax request
        if (events.containsKey(eventId)) {
            JavaScriptCommand.clear();
            events.get(eventId).getHandler().handle();
            return JavaScriptCommand.getCommands();
        }
        // first static request
        return view;
    }

    public String getPath() {
        return path;
    }

    protected final void onPageLoad(Handler handler) {
        events.put("-1null", new JavaScriptEvent(null, -1, null, handler));
    }

    protected final void onClick(Clickable clickable, Handler handler) {
        addEvent((HtmlComponent) clickable, "click", handler);
    }

    private void addEvent(HtmlComponent component, String eventType, Handler handler) {
        JavaScriptEvent event = new JavaScriptEvent(component.getXpath(), component.getId(), eventType, handler);
        events.put(event.getId(), event);
    }

    public final Collection<JavaScriptEvent> getEvents() {
        return events.values();
    }

}
