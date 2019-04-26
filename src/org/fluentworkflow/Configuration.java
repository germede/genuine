package org.fluentworkflow;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public static final String APP_PACKAGE = "APP_PACKAGE";
    public static final String APP_PORT = "APP_PORT";
    public static final String DB_DRIVER = "DB_DRIVER";
    public static final String DB_HOSTNAME = "DB_HOSTNAME";
    public static final String DB_PORT = "DB_PORT";
    public static final String DB_NAME = "DB_NAME";
    public static final String DB_USERNAME = "DB_USERNAME";
    public static final String DB_PASSWORD = "DB_PASSWORD";
    public static final String DB_URLPARAMS = "DB_URLPARAMS";
    public static final String LOG_INFO = "LOG_INFO";
    public static final String LOG_DEBUG = "LOG_DEBUG";
    public static final String LOG_WARNING = "LOG_WARNING";
    public static final String LOG_ERROR = "LOG_ERROR";
    public static final String LOG_FILE = "LOG_FILE";

    private Map<String, String> configuration = new HashMap<>();

    public Configuration set(String key, String value) {
        configuration.put(key, value);
        return this;
    }

    private static Configuration instance;

    static void set(Configuration configuration) {
        instance = configuration;
    }

    public static String get(String key) {
        return instance.configuration.get(key);
    }

}
