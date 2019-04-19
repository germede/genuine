package org.fwf.cli;

public interface Command {

    String getName();
    String getDescription();
    void execute();
}
