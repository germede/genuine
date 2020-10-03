package org.fluentness.application;

import org.fluentness.controller.WebController;
import org.fluentness.service.Services;
import org.fluentness.service.dispatcher.ResourceDispatcher;
import org.fluentness.service.dispatcher.RouteDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;
import org.fluentness.view.WebView;
import org.fluentness.view.component.navigation.HtmlNavigation;

import java.util.Arrays;

@Services({
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
            RouteDispatcher dispatcher = server.getRouteDispatcher();
            dispatcher.addRoute("GET", controller.getPath(), controller.getClass().getMethod("mainAction", String.class), controller);
            Arrays.stream(controller.getActions())
                .filter(method -> method.isAnnotationPresent(WebController.Action.class))
                .forEach(action -> {
                    WebController.Action annotation = action.getAnnotation(WebController.Action.class);
                    dispatcher.addRoute(annotation.method(), controller.getPath() + annotation.path(), action, controller);
                });
        }
        ((HtmlNavigation) WebView.navigation).setBrand(this.getClass().getSimpleName());
        server.start();
    }

}
