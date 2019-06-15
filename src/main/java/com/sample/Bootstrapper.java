package com.sample;

import org.fluentness.Fluentness;
import org.fluentness.base.settings.Settings;

public class Bootstrapper implements Settings.Keys {

    private static Settings dev = new Settings()
        .set(APP_PROTOCOL, "http")
        .set(APP_HOSTNAME, "localhost")
        .set(APP_PORT, 8000)
        .set(APP_KEYSTORE, "res/keystore.jks")
        .set(DB_DRIVER, "mysql")
        .set(DB_HOSTNAME, "localhost")
        .set(DB_PORT, 3306)
        .set(DB_NAME, "music")
        .set(DB_USERNAME, "party")
        .set(DB_PASSWORD, "party")
        .set(DB_PARAMS, "?serverTimezone=UTC")
        .set(LOG_LEVEL, "ALL")
        .set(LOG_CONSOLE, true)
        .set(LOG_FILE, true)
        .set(VIEW_CACHE, true)
        .set(STYLE_CACHE, true)
        .set(STYLE_MINIFY, true);

    public static void main(String[] args) {
        Fluentness.INSTANCE.initialize("com.sample", dev, args);
    }

}
