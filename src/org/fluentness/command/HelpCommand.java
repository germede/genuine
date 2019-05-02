package org.fluentness.command;

import org.fluentness.FnInst;
import org.fluentness.logging.Log;


public class HelpCommand implements Command {

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
        System.out.println("\n" + Log.ANSI_GREEN + "Available commands:\n");
        for (Command command : FnInst.getCommandInstances()) {
            String format = Log.ANSI_YELLOW + "%20s " + Log.ANSI_WHITE + "- %s\n";
            System.out.format(format, command.getName(), command.getDescription());
        }
    }
}
