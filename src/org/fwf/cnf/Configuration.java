package org.fwf.cnf;

import org.fwf.log.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    static {
        try (InputStream input = new FileInputStream("cnf/configuration.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            Log.e(e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static final String APP_PACKAGE = "app.package";
    public static final String APP_PORT = "app.port";
    public static final String DB_DRIVER = "db.driver";
    public static final String DB_HOSTNAME = "db.hostname";
    public static final String DB_PORT = "db.port";
    public static final String DB_NAME = "db.name";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";
    public static final String LOG_INFO = "log.info";
    public static final String LOG_DEBUG = "log.debug";
    public static final String LOG_WARNING = "log.warning";
    public static final String LOG_ERROR = "log.error";
    public static final String LOG_FILE = "log.error";

}
