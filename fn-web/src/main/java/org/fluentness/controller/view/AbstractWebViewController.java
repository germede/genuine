package org.fluentness.controller.view;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.controller.AbstractViewController;
import org.fluentness.controller.WebController;
import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebViewController<W extends AbstractWebView> extends AbstractViewController<W> implements WebController {

    private final String path;
    private final Map<String, JavaScriptEvent> events = new HashMap<>();

    public AbstractWebViewController(W view, String path) {
        super(view);
        this.path = path;
        AbstractWebView.navigation.addSectionFor(this);
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

    @Override
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
