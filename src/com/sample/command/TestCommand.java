package com.sample.command;

import org.fluentness.command.Command;
import org.fluentness.http.HttpServer;

public class TestCommand implements Command {

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "Test command for development";
    }

    @Override
    public void execute(String[] args) {
        HttpServer.start();
    }
}
