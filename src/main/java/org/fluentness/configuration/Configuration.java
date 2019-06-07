package org.fluentness.configuration;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Configuration {
    public static final String APP_PACKAGE = "app_package";
    public static final String APP_PROTOCOL = "app_protocol";
    public static final String APP_HOSTNAME = "app_hostname";
    public static final String APP_PORT = "app_port";
    public static final String APP_KEYSTORE = "app_keystore";
    public static final String DB_DRIVER = "db_driver";
    public static final String DB_HOSTNAME = "db_hostname";
    public static final String DB_PORT = "db_port";
    public static final String DB_NAME = "db_name";
    public static final String DB_USERNAME = "db_username";
    public static final String DB_PASSWORD = "db_password";
    public static final String DB_PARAMS = "db_params";
    public static final String CACHE_ENABLE = "cache_enable";
    public static final String LOG_LEVEL = "log_level";
    public static final String LOG_CONSOLE = "log_console";
    public static final String LOG_FILE = "log_file";

    private static Map<String, Object> configuration = new HashMap<>();

    public static void set(NamedValue<Object>[] configurations) {
        Arrays.stream(configurations).forEach(configurationProperty -> configuration.put(configurationProperty.name(), configurationProperty.value()));
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
