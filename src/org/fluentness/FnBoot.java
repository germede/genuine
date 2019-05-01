package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.logging.Log;
import org.fluentness.singleton.ClassRegister;

import java.util.List;

public class FnBoot {

    public static void initialize(String[] args, FnConf configuration) {
        FnConf.set(configuration);
        executeCommand(args);
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
                Log.error(FnBoot.class, "No command '" + args[0] + "' found");
            }
        } else {
            new HelpCommand().execute(args);
        }
    }
}
