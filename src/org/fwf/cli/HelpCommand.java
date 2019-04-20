package org.fwf.cli;

import org.fwf.obj.Register;
import org.fwf.Console;

public class HelpCommand implements Command {

    public String getName() {
        return "help";
    }

    public String getDescription() {
        return "Prints all available commands";
    }

    public void execute(String[] args) {

        // print commands using colors
        System.out.println("\n" + Console.ANSI_GREEN + "Available commands:\n");
        for (Command command : Register.getInstance().getCommandInstances()) {
            String format = Console.ANSI_YELLOW + "%20s " + Console.ANSI_WHITE + "- %s\n";
            System.out.format(format, command.getName(), command.getDescription());
        }
    }
}
