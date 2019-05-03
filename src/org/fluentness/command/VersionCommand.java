package org.fluentness.command;

public class VersionCommand implements Command {

    @Override
    public String getName() {
        return "version";
    }

    @Override
    public String getDescription() {
        return "Prints current version";
    }

    @Override
    public void execute(Parameters parameters) {
        System.out.println("1.0-dev");
    }

}
