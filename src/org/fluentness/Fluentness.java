package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.common.ClassRegister;
import org.fluentness.common.Configuration;
import org.fluentness.logging.Log;

import java.util.List;

public class Fluentness {

    public static void initialize(String[] args, Configuration configuration) {
        try {
            Configuration.set(configuration);
            executeCommand(args);
        } catch (Exception e) {
            Log.severe(Fluentness.class, e);
        }
    }

    private static void executeCommand(String[] args) {
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
                Log.severe(Fluentness.class, "No command '" + args[0] + "' found");
            }
        } else {
            new HelpCommand().execute(args);
        }
    }
}
