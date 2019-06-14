package com.sample;

import org.fluentness.Fluentness;

class Boot extends Fluentness {

    public static void main(String[] args) {
        set(APP_PROTOCOL, "http");
        set(APP_HOSTNAME, "localhost");
        set(APP_PORT, 8000);
        set(APP_KEYSTORE, "res/keystore.jks");
        set(PROVIDER_CONTROLLERS, new Controllers());
        set(PROVIDER_FORMS, new Forms());
        set(PROVIDER_LOCALIZATIONS, new Localizations());
        set(PROVIDER_MODELS, new Models());
        set(PROVIDER_STYLES, new Styles());
        set(PROVIDER_TASKS, new Tasks());
        set(PROVIDER_VIEWS, new Views());
        set(DB_DRIVER, "mysql");
        set(DB_HOSTNAME, "localhost");
        set(DB_PORT, 3306);
        set(DB_NAME, "music");
        set(DB_USERNAME, "party");
        set(DB_PASSWORD, "party");
        set(DB_PARAMS, "?serverTimezone=UTC");
        set(LOG_LEVEL, "ALL");
        set(LOG_CONSOLE, true);
        set(LOG_FILE, true);
        set(VIEW_CACHE_ENABLE, false);
        set(STYLE_MINIFY_ENABLE, true);

        init(args);
    }
}
