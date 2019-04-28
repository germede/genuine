package org.fluentness.command;

import org.fluentness.logging.Logger;
import org.fluentness.ClassRegister;

import java.util.List;

public class Console {

    public static void executeCommand(String[] args) {
        if (args.length > 0) {
            List<Command> commands = ClassRegister.getCommandInstances();
            boolean commandNotFound = true;
            for (Command command : commands) {
                if (command.getName().equals(args[0])) {
                    commandNotFound = false;
                    command.execute(args);
                }
            }
            if (commandNotFound) {
                Logger.error(Console.class, "No command '" + args[0] + "' found");
            }
        } else {
            new HelpCommand().execute(args);
        }
    }

    private Console () {

    }
}
