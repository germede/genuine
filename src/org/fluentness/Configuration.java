package org.fluentness;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    public static final Property APP_PACKAGE = new Property( "");
    public static final Property APP_PORT = new Property("8000");
    public static final Property APP_DEFAULT_LANGUAGE = new Property( "");
    public static final Property DB_DRIVER = new Property( "");
    public static final Property DB_HOSTNAME = new Property( "");
    public static final Property DB_PORT = new Property( "");
    public static final Property DB_NAME = new Property( "");
    public static final Property DB_USERNAME = new Property( "");
    public static final Property DB_PASSWORD = new Property( "");
    public static final Property DB_URL_PARAMS = new Property( "");
    public static final Property LOG_INFO = new Property( "");
    public static final Property LOG_DEBUG = new Property( "");
    public static final Property LOG_WARNING = new Property( "");
    public static final Property LOG_ERROR = new Property( "");
    public static final Property LOG_FILE = new Property( "");



    private Map<Property, Object> configuration = new HashMap<>();

    public Configuration set(Property property, Object value) {
        configuration.put(property, value);
        return this;
    }

    private static Configuration instance;

    static void set(Configuration configuration) {
        instance = configuration;
    }

    public static String get(Property property) {
        return String.valueOf(instance.configuration.get(property));
    }


    static class Property {

        private final String defaultValue;

        Property(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }
}
