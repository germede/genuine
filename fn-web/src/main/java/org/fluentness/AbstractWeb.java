package org.fluentness;

import org.fluentness.controller.WebController;
import org.fluentness.controller.action.AbstractWebService;
import org.fluentness.controller.event.AbstractWebController;
import org.fluentness.controller.event.JavaScriptEvent;
import org.fluentness.service.Services;
import org.fluentness.service.dispatcher.EventDispatcher;
import org.fluentness.service.dispatcher.RouteDispatcher;
import org.fluentness.service.dispatcher.ResourceDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;

import java.util.Arrays;

@Services({
    RouteDispatcher.class,
    ResourceDispatcher.class,
    EventDispatcher.class,
    TomcatServer.class,
    SocketMail.class,
})
public abstract class AbstractWeb implements Application {

    private final Server server;
    private final EventDispatcher eventDispatcher;
    private final RouteDispatcher routeDispatcher;
    private final WebController[] controllers;

    public AbstractWeb(Server server, WebController... controllers) {
        this.server = server;
        this.eventDispatcher = server.getEventDispatcher();
        this.routeDispatcher = server.getRouteDispatcher();
        this.controllers = controllers;
    }

    @Override
    public final void run(String[] args) {
        try {
            for (WebController controller : controllers) {
                if (controller instanceof AbstractWebController) {
                    routeDispatcher.addRoute("GET", controller.getPath(), controller.getClass().getMethod("main", String.class), controller);
                    for (JavaScriptEvent event : (Iterable<JavaScriptEvent>) ((AbstractWebController) controller).getEvents()) {
                        eventDispatcher.addEvent(event);
                    }
                }
                if (controller instanceof AbstractWebService) {
                    Arrays.stream(((AbstractWebService) controller).getActions()).forEach(action -> {
                        AbstractWebService.Action annotation = action.getAnnotation(AbstractWebService.Action.class);
                        routeDispatcher.addRoute(annotation.method(), controller.getPath() + annotation.path(), action, controller);
                    });
                }
            }
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
