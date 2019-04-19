package org.fwf;

import org.fwf.cli.Command;
import org.fwf.cli.HelpCommand;
import org.fwf.obj.ClassRegister;

import java.util.Set;

public class Console {

    public static void main(String[] args) {

        if (args.length == 0) {
            new HelpCommand().execute();
        } else {
            Set<Command> commands = ClassRegister.getInstance().getCommandInstances();
            for (Command command : commands) {
                if (command.getName().equals(args[0])) {
                    command.execute();
                }
            }
        }
    }
}
