package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.Services;
import org.fluentness.service.dispatcher.DynamicDispatcher;
import org.fluentness.service.dispatcher.JavaScriptDispatcher;
import org.fluentness.service.dispatcher.StaticDispatcher;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;

@Services({
    DynamicDispatcher.class,
    StaticDispatcher.class,
    JavaScriptDispatcher.class,
    TomcatServer.class,
    SocketMail.class,
})
public abstract class AbstractWeb implements Application {

    private final Server server;
    private final AbstractWebController[] controllers;

    public AbstractWeb(Server server, AbstractWebController... controllers) {
        this.server = server;
        this.controllers = controllers;
    }

    @Override
    public final void run(String[] args) {
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
