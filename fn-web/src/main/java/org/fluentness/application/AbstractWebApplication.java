package org.fluentness.application;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.controller.WebController;
import org.fluentness.controller.action.AbstractWebActionController;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.JavaScriptEvent;
import org.fluentness.service.dispatcher.EventDispatcher;
import org.fluentness.service.dispatcher.ResourceDispatcher;
import org.fluentness.service.dispatcher.RouteDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;
import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.navigation.HtmlNavigation;

import java.util.Arrays;

@Application.Services({
    RouteDispatcher.class,
    ResourceDispatcher.class,
    EventDispatcher.class,
    TomcatServer.class,
    SocketMail.class,
})
public abstract class AbstractWebApplication implements Application {

    private final Server server;
    private final WebController[] controllers;

    public AbstractWebApplication(Server server, WebController... controllers) {
        this.server = server;
        this.controllers = controllers;
    }

    @Override
    public final void run(String[] args) throws Exception {
        for (AbstractWebController controller : controllers) {
            server.getRouteDispatcher().addRoute(
                "GET",
                controller.getPath(),
                controller.getClass().getMethod("main", String.class, HttpServletRequest.class),
                controller
            );
            // add events listeners to javascript
            for (JavaScriptEvent event : (Iterable<JavaScriptEvent>) ((AbstractWebController) controller).getEvents()) {
                server.getEventDispatcher().addEventListener(event);
            }
            Arrays.stream(controller.getActions()).forEach(action -> {
                AbstractWebActionController.Action annotation = action.getAnnotation(AbstractWebActionController.Action.class);
                server.getRouteDispatcher().addRoute(annotation.method(), controller.getPath() + annotation.path(), action, controller);
            });
        }
        ((HtmlNavigation) AbstractWebView.navigation).setBrand(this.getClass().getSimpleName());
        server.start();
    }

}
