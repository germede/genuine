package org.fluentness.command;

import org.fluentness.register.ClassRegister;

import java.util.*;


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
    public void execute(String... parameters) {
        System.out.println("\n" +
                "   .-._.---'.                                             \n" +
                "  (_) /    /                    /                         \n" +
                "     /--. / )  (   .-..  .-.---/---.  .-.   .-.  .    .   \n" +
                "    /    / (    )./.-'_)/   ) /     )/   )./.-'_/ \\  / \\  \n" +
                " .-/   _/_.-`--':(__.''/   ( /     '/   ( (__.'/ ._)/ ._) \n" +
                "(_/                         `-           `-   /    /      \n");

        System.out.println(ANSI_RESET + "Available commands:\n");

        // categorize commands
        Map<String, List<Command>> categorizedCommands = new HashMap<>();
        categorizedCommands.put("", new ArrayList<>());
        for (Command command : ClassRegister.getCommandInstances()) {
            String[] splittedCommand = command.getName().split(":");
            if (splittedCommand.length == 2) {
                if (!categorizedCommands.containsKey(splittedCommand[0])) {
                    categorizedCommands.put(splittedCommand[0], new ArrayList<>());
                }
                categorizedCommands.get(splittedCommand[0]).add(command);
            } else {
                categorizedCommands.get("").add(command);
            }
        }

        // prints categories and commands
        for (Map.Entry<String, List<Command>> category : categorizedCommands.entrySet()) {
            if (!category.getKey().isEmpty()) {
                System.out.println(ANSI_GREEN + "- " + category.getKey() + ":" + ANSI_RESET);
            }
            category.getValue().forEach(Command::printUsage);
            System.out.println();
        }
    }
}
