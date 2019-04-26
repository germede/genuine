package org.fluentness.cli;

public class VersionCommand implements Command {

    @Override
    public String getName() {
        return "version";
    }

    @Override
    public String getDescription() {
        return "Prints used frameworkflow version";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("1.0-dev");
    }
}
