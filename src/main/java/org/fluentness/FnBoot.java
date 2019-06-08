package org.fluentness;

import org.fluentness.common.logging.Logger;
import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.task.Command;
import org.fluentness.task.DefaultTasks;
import org.fluentness.task.TaskProvider;

public final class FnBoot {

    public static void initialize(String[] args, NamedValue<Object>... settings) {

        FnConf.setSettings(settings);

        Command commandToExecute = null;
        if (args.length == 0) {
            new DefaultTasks().help.getCommands()[0].value().getExecutor().execute(new String[0]);
            return;
        }

        for (NamedValue<Command> command : TaskProvider.retrieveAllCommands()) {
            if (args[0].equals(command.name())) {
                commandToExecute = command.value();
            }
        }
        if (commandToExecute == null) {
            Logger.error("No command %s found", args[0]);
            return;
        }

        String[] declaredParameters = commandToExecute.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Logger.error("Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            return;
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        commandToExecute.getExecutor().execute(parameters);
    }
}
