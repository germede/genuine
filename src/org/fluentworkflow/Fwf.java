package org.fluentworkflow;

import org.fluentworkflow.cli.Console;

public class Fwf {

    public static void initialize(String[] args, Configuration configuration) {
        Configuration.set(configuration);
        Console.executeCommand(args);
    }
}
