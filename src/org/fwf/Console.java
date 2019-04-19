package org.fwf;

import org.fwf.cli.Command;
import org.fwf.cli.HelpCommand;
import org.fwf.log.Log;
import org.fwf.obj.ClassRegister;

import java.util.Set;

public class Console {

    public static void main(String[] args) {

        if (args.length == 0) {
            new HelpCommand().execute(args);
        } else {
            executeCommand(args);
        }
    }

    public static void executeCommand(String[] args) {
        Set<Command> commands = ClassRegister.getInstance().getCommandInstances();
        boolean commandNotFound = true;
        for (Command command : commands) {
            if (command.getName().equals(args[0])) {
                commandNotFound = false;
                command.execute(args);
            }
        }
        if (commandNotFound) {
            Log.e("No command '" + args[0] + "' found");
        }
    }
}
