package org.fluentness.command;

import org.fluentness.http.HttpServer;

public class ServerStartCommand implements Command {

    @Override
    public String getName() {
        return "server:start";
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
