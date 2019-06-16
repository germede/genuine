package com.sample;

import org.fluentness.Fluentness;
import org.fluentness.configuration.Configuration;
import org.fluentness.configuration.ConfigurationProvider;

public class Configurations extends ConfigurationProvider {

    Configuration dev = settings(
        set(APP_PROTOCOL, "http"),
        set(APP_HOSTNAME, "localhost"),
        set(APP_PORT, 8000),
        set(APP_KEYSTORE, "res/keystore.jks"),
        set(DB_DRIVER, "mysql"),
        set(DB_HOSTNAME, "localhost"),
        set(DB_PORT, 3306),
        set(DB_NAME, "music"),
        set(DB_USERNAME, "party"),
        set(DB_PASSWORD, "party"),
        set(DB_PARAMS, "?serverTimezone=UTC"),
        set(LOG_LEVEL, "ALL"),
        set(LOG_TO_CONSOLE, true),
        set(LOG_TO_FILE, true),
        set(CACHE_ENABLE, true),
        set(STYLE_MINIFY, true)
    );

    Configuration prod = settings(
        set(APP_PROTOCOL, "https"),
        set(APP_HOSTNAME, "localhost"),
        set(APP_PORT, 8000),
        set(APP_KEYSTORE, "res/keystore.jks"),
        set(DB_DRIVER, "mysql"),
        set(DB_HOSTNAME, "localhost"),
        set(DB_PORT, 3306),
        set(DB_NAME, "music"),
        set(DB_USERNAME, "party"),
        set(DB_PASSWORD, "party"),
        set(DB_PARAMS, "?serverTimezone=UTC"),
        set(LOG_LEVEL, "ALL"),
        set(LOG_TO_CONSOLE, true),
        set(LOG_TO_FILE, true),
        set(CACHE_ENABLE, true),
        set(STYLE_MINIFY, true)
    );

    public static void main(String[] args) {
        Fluentness.INSTANCE.initialize("com.sample","dev", args);
    }
}
