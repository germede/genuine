package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.common.ClassRegister;
import org.fluentness.common.Configuration;
import org.fluentness.logging.Logger;

public class Fluentness {

    public static void initialize(String[] args, Configuration configuration) {
        try {
            Configuration.set(configuration);
            executeCommand(args);
        } catch (Exception e) {
            Logger.severe(Fluentness.class, e);
        }
    }

    private static void executeCommand(String[] args) {
        if (args.length > 0) {
            if (ClassRegister.getCommandInstances().stream().anyMatch(cmd -> cmd.getName().equals(args[0]))) {
                Command command = ClassRegister.getCommandInstances().stream().filter(cmd -> cmd.getName().equals(args[0])).findFirst().get();

                Command.Parameters parameters = command.getParameters();
                if ((parameters == null || parameters.size() == args.length - 1) &&
                        (parameters != null || args.length != 1)) {

                    for (int i = 1; i < args.length; i++) {
                        parameters.set(i - 1, args[i]);
                    }
                    command.execute(parameters);

                } else {
                    // Wrong arguments
                    Logger.severe(Fluentness.class, "Wrong use of command %s, expected %s arguments", args[0], parameters.size());
                }
            } else {
                // No command found
                Logger.severe(Fluentness.class, "No command %s found", args[0]);
            }
        } else {
            // No command
            new HelpCommand().execute(null);
        }
    }
}
