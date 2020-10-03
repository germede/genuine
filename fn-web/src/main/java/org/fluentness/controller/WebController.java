package org.fluentness.controller;

import jakarta.servlet.http.HttpServletRequest;
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
        if (eventId != null) {
            JavaScriptCommand.clear();
            if (events.containsKey(eventId)) events.get(eventId).handle();
            else if (eventId.equals("pageload")) onPageLoad();
            return JavaScriptCommand.getCommands();
        }
        // first static request
        return view;
    }

    public String getPath() {
        return path;
    }

    protected void onPageLoad() {

    }

    protected final void onClick(HtmlComponent component, Handler handler) {
        String eventId = component.getId() + "click";
        component.withAttribute("onclick", "send('" + eventId + "');");
        events.put(eventId, handler);
    }

}
