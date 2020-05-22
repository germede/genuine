package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.ServiceLoader;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.dispatcher.Dispatcher;
import org.fluentness.service.mail.Mail;
import org.fluentness.service.server.Server;

public abstract class AbstractWeb implements Application {

    static {
        ServiceLoader.registerService(Authentication.class);
        ServiceLoader.registerService(Dispatcher.class);
        ServiceLoader.registerService(Mail.class);
        ServiceLoader.registerService(Server.class);
    }

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
