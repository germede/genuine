package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.common.NamedValue;
import org.fluentness.configuration.Configuration;
import org.fluentness.logger.Logger;
import org.fluentness.register.CommandRegister;

public final class Fluentness {

    public static void initialize(String[] args, NamedValue<Object>... configurations) {
        try {
            Configuration.set(configurations);
            executeCommand(args);
        } catch (Exception e) {
            Logger.error(Fluentness.class, e);
        }
    }

    private static void executeCommand(String[] args) {
        if (args.length <= 0) {
            new HelpCommand().execute();
            return;
        }

        if (CommandRegister.getCommandInstances().stream().noneMatch(cmd -> cmd.getName().equals(args[0]))) {
            Logger.error(Fluentness.class, "No command %s found", args[0]);
            return;
        }

        Command command = CommandRegister.getCommandInstances().stream().filter(cmd -> cmd.getName().equals(args[0])).findFirst().get();
        String[] declaredParameters = command.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Logger.error(Fluentness.class, "Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            return;
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        command.execute(parameters);
    }


}
