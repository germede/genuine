package org.fwf.cli;

import org.fwf.log.Logger;
import org.fwf.log.Severity;
import org.fwf.obj.ClassRegister;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.fwf.cli.CliColor.*;

public class HelpCommand implements Command {

    public String getName() {
        return "help";
    }

    public String getDescription() {
        return "Prints all available commands";
    }

    public void execute() {
        Set<Class<? extends Command>> commandClasses = ClassRegister.getInstance().getCommandClasses();

        // sort commands alphabetically
        List<Class<? extends Command>> sortedCommandClasses = new ArrayList<>(commandClasses);
        sortedCommandClasses.sort(Comparator.comparing(Class::getName));

        // print commands using colors
        System.out.println("\n" + ANSI_GREEN + "Available commands:\n");
        for (Class commandClass : sortedCommandClasses) {
            try {
                Command command = (Command) commandClass.newInstance();
                String format = ANSI_YELLOW + "%20s " + ANSI_WHITE + "- %s\n";
                System.out.format(format, command.getName(), command.getDescription());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.log(Severity.ERROR, e.getMessage(), e);
            }
        }
    }
}
