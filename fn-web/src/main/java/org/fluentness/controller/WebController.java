package org.fluentness.controller;

import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.event.Handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class WebController<W extends WebView> extends ViewController<W> {

    private final String path;
    private final Map<String, Handler> events = new HashMap<>();

    public WebController(W view, String path) {
        super(view);
        this.path = path;
        WebView.navigation.addItem(this);

    }

    public String getPath() {
        return path;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

        String path();
        String method() default GET;

    }
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RequestParameter {

    }
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SessionAttribute {

    }

    public final Object mainAction(@RequestParameter String eventId) {
        // dynamic ajax request
        if (eventId != null) {
            if (events.containsKey(eventId)) events.get(eventId).handle();
            else if (eventId.equals("pageload")) onPageLoad();
            return null;
        }
        // first static request
        return view;
    }

    protected void onPageLoad() {

    }

    protected final void onClick(HtmlComponent component, Handler handler) {
        String eventId = component.getId() + "click";
        component.withAttribute("onclick", "send('" + eventId + "');");
        events.put(eventId, handler);
    }

}
