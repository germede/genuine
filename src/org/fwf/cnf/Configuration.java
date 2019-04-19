package org.fwf.cnf;

import org.fwf.log.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static void readConfiguration() {

        try (InputStream input = new FileInputStream("cnf/configuration.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException e) {
            Log.e(e.getMessage(),e);
        }

    }
}
