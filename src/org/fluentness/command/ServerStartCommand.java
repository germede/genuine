package org.fluentness.command;

import org.fluentness.networking.HttpServer;

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
    public void execute(Parameters parameters) {
        HttpServer.start();
        Runtime.getRuntime().addShutdownHook(new Thread(HttpServer::stop));
    }
}
