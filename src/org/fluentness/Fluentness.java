package org.fluentness;

import org.fluentness.command.Command;
import org.fluentness.command.HelpCommand;
import org.fluentness.common.ClassRegister;
import org.fluentness.common.NamedValue;
import org.fluentness.logging.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fluentness {

    public static void initialize(String[] args, NamedValue<Object>... configurations) {
        try {
            Configuration.set(configurations);
            executeCommand(args);
        } catch (Exception e) {
            Logger.error(Fluentness.class, e);
        }
    }

    private static void executeCommand(String[] args) {
        if (args.length > 0) {
            if (ClassRegister.getCommandInstances().stream().anyMatch(cmd -> cmd.getName().equals(args[0]))) {
                Command command = ClassRegister.getCommandInstances().stream().filter(cmd -> cmd.getName().equals(args[0])).findFirst().get();

                Command.Parameters parameters = command.getParameters();
                if ((parameters == null || parameters.size() == args.length - 1) &&
                        (parameters != null || args.length != 1)) {

                    for (int i = 1; i < args.length; i++) {
                        parameters.set(i - 1, args[i]);
                    }
                    command.execute(parameters);

                } else {
                    // Wrong arguments
                    Logger.error(Fluentness.class, "Wrong use of command %s, expected %s arguments", args[0], parameters.size());
                }
            } else {
                // No command found
                Logger.error(Fluentness.class, "No command %s found", args[0]);
            }
        } else {
            // No command
            new HelpCommand().execute(null);
        }
    }

    public static class Configuration {
        public static final String APP_PACKAGE = "APP_PACKAGE";
        public static final String APP_PROTOCOL = "APP_PROTOCOL";
        public static final String APP_HOSTNAME = "APP_HOSTNAME";
        public static final String APP_PORT = "APP_PORT";
        public static final String APP_KEYSTORE = "APP_KEYSTORE";
        public static final String APP_LANGUAGE = "APP_LANGUAGE";
        public static final String DB_DRIVER = "DB_DRIVER";
        public static final String DB_HOSTNAME = "DB_HOSTNAME";
        public static final String DB_PORT = "DB_PORT";
        public static final String DB_NAME = "DB_NAME";
        public static final String DB_USERNAME = "DB_USERNAME";
        public static final String DB_PASSWORD = "DB_PASSWORD";
        public static final String DB_PARAMS = "DB_PARAMS";
        public static final String CACHE_ENABLE = "CACHE_ENABLE";
        public static final String LOG_LEVEL = "LOG_LEVEL";
        public static final String LOG_CONSOLE = "LOG_CONSOLE";
        public static final String LOG_FILE = "LOG_FILE";

        private static Map<String, Object> configuration = new HashMap<>();

        public static void set(NamedValue<Object>[] configurations) {
            Arrays.stream(configurations).forEach(configurationProperty -> configuration.put(configurationProperty.name(),configurationProperty.value()));
        }

        public static String getString(String key) {
            return String.valueOf(configuration.get(key));
        }

        public static int getInt(String key) {
            return (int) configuration.get(key);
        }

        public static boolean getBoolean(String key) {
            if (configuration.containsKey(key)) {
                return (boolean) configuration.get(key);
            }
            return true;
        }

        public static boolean contains(String key) {
            return configuration.containsKey(key);
        }
    }
}
