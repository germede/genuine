package com.sample.commands;

import org.fluentness.cli.Command;
import org.fluentness.net.Server;

public class TestCommand implements Command {

    public String getName() {
        return "test";
    }

    public String getDescription() {
        return "Test command for development";
    }

    public void execute(String[] args) {
        Server.start();
    }
}
