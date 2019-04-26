package org.fluentness;

import org.fluentness.cli.Console;

public class Bootstrapper {

    public static void initialize(String[] args, Configuration configuration) {
        Configuration.set(configuration);
        Console.executeCommand(args);
    }
}
