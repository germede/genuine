package com.sample.command;

import org.fluentness.command.Command;


public class TestCommand implements Command {

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "Test command";
    }

    @Override
    public void execute(Parameters parameters) {
        System.out.println("test");
    }
}
