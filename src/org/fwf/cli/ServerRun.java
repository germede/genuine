package org.fwf.cli;

public class ServerRun implements Command {

    public String getName() {
        return "server:run";
    }

    public String getDescription() {
        return "Runs server";
    }

    public void execute() {
        System.out.println("say hello");
    }
}
