package org.fluentness.base.settings;

import org.fluentness.base.generics.Register;

public class Settings implements Register<String, Object> {

    public Settings() {

    }

    public Settings set(String key, Object value) {
        put(key, value);
        return this;
    }

    public void apply() {
        Configuration.settings = this;
    }

    public interface Keys {
        String APP_PACKAGE = "APP_PACKAGE";
        String APP_PROTOCOL = "APP_PROTOCOL";
        String APP_HOSTNAME = "APP_HOSTNAME";
        String APP_PORT = "APP_PORT";
        String APP_KEYSTORE = "APP_KEYSTORE";
        String DB_DRIVER = "DB_DRIVER";
        String DB_HOSTNAME = "DB_HOSTNAME";
        String DB_PORT = "DB_PORT";
        String DB_NAME = "DB_NAME";
        String DB_USERNAME = "DB_USERNAME";
        String DB_PASSWORD = "DB_PASSWORD";
        String DB_PARAMS = "DB_PARAMS";
        String LOG_LEVEL = "LOG_LEVEL";
        String LOG_CONSOLE = "LOG_CONSOLE";
        String LOG_FILE = "LOG_FILE";
        String VIEW_CACHE = "VIEW_CACHE";
        String STYLE_CACHE = "STYLE_CACHE";
        String STYLE_MINIFY = "STYLE_MINIFY";
    }
}
