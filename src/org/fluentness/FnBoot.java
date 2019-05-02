package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.logging.Log;

import java.util.List;

public class FnBoot {

    public static void initialize(String[] args, FnConf configuration) {
        try {
            FnConf.set(configuration);
            executeCommand(args);
        } catch (Exception e) {
            Log.error(FnBoot.class, e);
        }
    }

    private static void executeCommand(String[] args) {
        if (args.length > 0) {
            List<Command> commands = FnInst.getCommandInstances();
            boolean commandNotFound = true;
            for (Command command : commands) {
                if (command.getName().equals(args[0])) {
                    commandNotFound = false;
                    command.execute(args);
                }
            }
            if (commandNotFound) {
                Log.error(FnBoot.class, "No command '" + args[0] + "' found");
            }
        } else {
            new HelpCommand().execute(args);
        }
    }
}
