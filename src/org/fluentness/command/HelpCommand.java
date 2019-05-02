package org.fluentness.command;

import org.fluentness.common.ClassRegister;
import org.fluentness.common.AnsiColors;


public class HelpCommand implements Command, AnsiColors {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Prints all available commands";
    }

    @Override
    public void execute(String[] args) {

        // print commands using colors
        System.out.println("\n" + ANSI_GREEN + "Available commands:\n");
        for (Command command : ClassRegister.getCommandInstances()) {
            String format = ANSI_YELLOW + "%20s " + ANSI_WHITE + "- %s\n";
            System.out.format(format, command.getName(), command.getDescription());
        }
    }
}
