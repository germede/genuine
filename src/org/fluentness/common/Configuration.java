package org.fluentness.common;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
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

    private Map<String, Object> configuration = new HashMap<>();

    public Configuration set(String key, Object value) {
        configuration.put(key, value);
        return this;
    }

    private static Configuration instance;

    public static void set(Configuration context) {
        instance = context;
    }

    public static String getString(String key) {
        return String.valueOf(instance.configuration.get(key));
    }

    public static int getInt(String key) {
        return (int) instance.configuration.get(key);
    }

    public static boolean getBoolean(String key) {
        return (boolean) instance.configuration.get(key);
    }
}
