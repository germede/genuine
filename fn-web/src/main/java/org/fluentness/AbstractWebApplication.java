package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.Services;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.router.RouterImpl;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;

@Services({
    RouterImpl.class,
    SunServer.class,
    SocketMail.class,
})
public abstract class AbstractWebApplication implements Application {

    private final Server server;
    private final AbstractWebController[] controllers;

    public AbstractWebApplication(Server server, AbstractWebController... controllers) {
        this.server = server;
        this.controllers = controllers;
    }

    @Override
    public final void run(String[] args) throws Exception {
        server.start();
    }

}
