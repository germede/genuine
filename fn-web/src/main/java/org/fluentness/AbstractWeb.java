package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.Services;
import org.fluentness.service.authentication.AuthenticationImpl;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.TomcatServer;
import org.fluentness.service.dispatcher.DynamicDispatcher;
import org.fluentness.service.dispatcher.StaticDispatcher;

@Services({
    AuthenticationImpl.class,
    DynamicDispatcher.class,
    StaticDispatcher.class,
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
    public final void run(String[] args) throws Exception {
        server.start();
    }

}
