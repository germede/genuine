package org.fluentness.command;

import org.fluentness.networking.HttpServer;

public class ServerStopCommand implements Command {

    @Override
    public String getName() {
        return "server:stops";
    }

    @Override
    public String getDescription() {
        return "Stops embedded HTTP server";
    }

    @Override
    public void execute(Parameters parameters) {
        HttpServer.stop();
    }
}
