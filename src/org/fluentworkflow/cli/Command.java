package org.fluentworkflow.cli;

public interface Command {

    String getName();
    String getDescription();
    void execute(String[] args);
}
