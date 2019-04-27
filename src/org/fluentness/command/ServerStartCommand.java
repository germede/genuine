package org.fluentness.command;

import org.fluentness.routing.HttpServer;

public class ServerStartCommand implements Command {

    @Override
    public String getName() {
        return "server:run";
    }

    @Override
    public String getDescription() {
        return "Starts embedded HTTP server";
    }

    @Override
    public void execute(String[] args) {
        HttpServer.start();
    }
}
