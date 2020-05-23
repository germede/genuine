package org.fluentness;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.controller.WebController;
import org.fluentness.controller.action.AbstractActionWebController;
import org.fluentness.controller.event.AbstractEventWebController;
import org.fluentness.controller.event.JavaScriptEvent;
import org.fluentness.service.Services;
import org.fluentness.service.dispatcher.EventDispatcher;
import org.fluentness.service.dispatcher.RouteDispatcher;
import org.fluentness.service.dispatcher.StaticDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;

import java.util.Arrays;

@Services({
    RouteDispatcher.class,
    StaticDispatcher.class,
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
                if (controller instanceof AbstractEventWebController) {
                    routeDispatcher.addRoute("GET", controller.getPath(), controller.getClass().getMethod("main", String.class), controller);
                    for (JavaScriptEvent event : (Iterable<JavaScriptEvent>) ((AbstractEventWebController) controller).getEvents()) {
                        eventDispatcher.addEvent(event);
                    }
                }
                if (controller instanceof AbstractActionWebController) {
                    Arrays.stream(((AbstractActionWebController) controller).getActions()).forEach(action -> {
                        AbstractActionWebController.Action annotation = action.getAnnotation(AbstractActionWebController.Action.class);
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
