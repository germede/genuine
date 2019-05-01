package com.sample.command;

import org.fluentness.command.Command;
import org.fluentness.server.HttpServer;

public class TestCommand implements Command {

    public String getName() {
        return "test";
    }

    public String getDescription() {
        return "Test command for development";
    }

    public void execute(String[] args) {
        HttpServer.start();
    }
}
