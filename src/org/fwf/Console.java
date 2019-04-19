package org.fwf;

import org.fwf.cli.Command;
import org.fwf.log.Logger;
import org.fwf.log.Severity;
import org.fwf.obj.ClassRegister;

import java.util.Set;

public class Console {

    public static void main(String[] args) {

        printCommands();

    }

    private static void printCommands() {
        Set<Class<? extends Command>> commandClasses = ClassRegister.getInstance().getCommandClasses();
        for (Class commandClass : commandClasses) {
            try {
                Command command = (Command) commandClass.newInstance();
                command.execute();
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.log(Severity.ERROR, e.getMessage(), e);
            }
        }
    }

}
