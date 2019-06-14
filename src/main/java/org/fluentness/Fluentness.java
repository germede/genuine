package org.fluentness;

import org.fluentness.base.constants.Settings;
import org.fluentness.base.generics.Register;
import org.fluentness.base.logging.Log;
import org.fluentness.task.Command;
import org.fluentness.task.TaskProvider;
import org.fluentness.task.TaskProviderImpl;

import java.util.Map;

public class Fluentness implements Register<String, Object>, Settings {

    private static Fluentness instance = new Fluentness();
    
    protected static void set(String key, Object value) {
        instance.put(key,value);
    }

    public static String getString(String setting) {
        return String.valueOf(instance.get(setting));
    }

    public static int getInt(String setting) {
        return (int) instance.get(setting);
    }

    public static boolean getBoolean(String setting) {
        if (instance.containsKey(setting)) {
            return (boolean) instance.get(setting);
        }
        return true;
    }

    public static Object getObject(String setting) {
        if (instance.containsKey(setting)) {
            return instance.get(setting);
        }
        return null;
    }

    public static Object getOrDefault(String setting, Object defaultObject) {
        if (instance.containsKey(setting)) {
            return instance.get(setting);
        }
        return defaultObject;
    }

    public static boolean contains(String setting) {
        return instance.containsKey(setting);
    }

    protected static void init(String[] args) {

        Command commandToExecute = null;
        if (args.length == 0) {
            new TaskProviderImpl().help.getCommands()[0].value().getExecutor().execute(new String[0]);
            return;
        }

        for (Map.Entry<String,Command> command : TaskProvider.retrieveAllCommands().entrySet()) {
            if (args[0].equals(command.getKey())) {
                commandToExecute = command.getValue();
            }
        }
        if (commandToExecute == null) {
            Log.error("No command %s found", args[0]);
            return;
        }

        String[] declaredParameters = commandToExecute.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Log.error("Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            return;
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        commandToExecute.getExecutor().execute(parameters);
    }
}
