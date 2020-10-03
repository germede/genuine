package org.fluentness.application;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.controller.WebController;
import org.fluentness.service.dispatcher.ResourceDispatcher;
import org.fluentness.service.dispatcher.RouteDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;
import org.fluentness.view.WebView;
import org.fluentness.view.component.navigation.HtmlNavigation;

import java.util.Arrays;

@Application.Services({
    RouteDispatcher.class,
    ResourceDispatcher.class,
    TomcatServer.class,
    SocketMail.class,
})
public abstract class WebApplication implements Application {

    private final Server server;
    private final WebController[] controllers;

    public WebApplication(Server server, WebController... controllers) {
        this.server = server;
        this.controllers = controllers;
    }

    @Override
    public final void run(String[] args) throws Exception {
        for (WebController controller : controllers) {
            server.getRouteDispatcher().addRoute(
                "GET",
                controller.getPath(),
                controller.getClass().getMethod("main", String.class, HttpServletRequest.class),
                controller
            );
            Arrays.stream(controller.getActions())
                .filter(method -> method.isAnnotationPresent(WebController.Action.class))
                .forEach(action -> {
                    WebController.Action annotation = action.getAnnotation(WebController.Action.class);
                    server.getRouteDispatcher().addRoute(annotation.method(), controller.getPath() + annotation.path(), action, controller);
                });
        }
        ((HtmlNavigation) WebView.navigation).setBrand(this.getClass().getSimpleName());
        server.start();
    }

}
