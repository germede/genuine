package org.fwf.cli;

public class TestCommand implements Command {

    public String getName() {
        return "test";
    }

    public String getDescription() {
        return "Test command for development";
    }

    public void execute(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
