package org.fluentworkflow.cli;

import org.fluentworkflow.obj.Register;
import org.fluentworkflow.Fwf;

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
        System.out.println("\n" + Fwf.ANSI_GREEN + "Available commands:\n");
        for (Command command : Register.getInstance().getCommandInstances()) {
            String format = Fwf.ANSI_YELLOW + "%20s " + Fwf.ANSI_WHITE + "- %s\n";
            System.out.format(format, command.getName(), command.getDescription());
        }
    }
}
