package org.fwf.cli;

import org.fwf.net.Server;

public class ServerStartCommand implements Command {

    public String getName() {
        return "server:run";
    }

    public String getDescription() {
        return "Starts embedded HTTP server";
    }

    public void execute(String[] args) {
        Server.start();
    }
}
