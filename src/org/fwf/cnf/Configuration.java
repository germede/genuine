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

    public static final String BASE_PACKAGE = "basePackage";

}
