package org.fwf.cli;

public class VersionCommand implements Command {

    public String getName() {
        return "version";
    }

    public String getDescription() {
        return "Prints used frameworkflow version";
    }

    public void execute(String[] args) {
        System.out.println("1.0-dev");
    }
}
