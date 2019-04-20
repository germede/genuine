package com.sample.command;

import org.fwf.cli.Command;
import org.fwf.net.Server;

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
