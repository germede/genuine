package org.fluentness.register;

import org.fluentness.command.Command;
import org.fluentness.logging.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class CommandRegister
{
    public static final String COMMAND = "command";

    private static final List<Command> commandInstances;

    static {
        commandInstances = new ArrayList<>();
        for (Class commandClass : ClassLoader.getAllClasses(COMMAND, Command.class)) {
            try {
                Command command = (Command) commandClass.newInstance();
                ClassInjector.injectFields(command);
                commandInstances.add(command);
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
        commandInstances.sort(Comparator.comparing(Command::getName));
    }

    public static List<Command> getCommandInstances() {
        return commandInstances;
    }
}
