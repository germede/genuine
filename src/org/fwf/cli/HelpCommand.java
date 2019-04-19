package org.fwf.cli;

import org.fwf.log.Logger;
import org.fwf.log.Severity;
import org.fwf.obj.ClassRegister;

import java.util.Set;

public class HelpCommand implements Command {

    public String getName() {
        return "help";
    }

    public String getDescription() {
        return "Print all available commands";
    }

    public void execute() {
        Set<Class<? extends Command>> commandClasses = ClassRegister.getInstance().getCommandClasses();
        for (Class commandClass : commandClasses) {
            try {
                Command command = (Command) commandClass.newInstance();
                System.out.println(command.getName() + " " + command.getDescription());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.log(Severity.ERROR, e.getMessage(), e);
            }
        }
    }
}
