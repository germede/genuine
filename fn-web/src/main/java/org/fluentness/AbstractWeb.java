package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.server.Server;

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
