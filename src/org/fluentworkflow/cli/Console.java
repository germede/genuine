package org.fluentworkflow.cli;

import org.fluentworkflow.log.Logger;
import org.fluentworkflow.oop.Register;

import java.util.Set;

public class Console {
    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";

    public static void executeCommand(String[] args) {
        Set<Command> commands = Register.getCommandInstances();
        boolean commandNotFound = true;
        for (Command command : commands) {
            if (command.getName().equals(args[0])) {
                commandNotFound = false;
                command.execute(args);
            }
        }
        if (commandNotFound) {
            Logger.e("No command '" + args[0] + "' found");
        }
    }
}
