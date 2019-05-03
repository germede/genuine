package com.sample;

import org.fluentness.Fluentness;
import org.fluentness.common.Configuration;

public class Dev {

    public static void main(String[] args) {

        Fluentness.initialize(args, new Configuration()
                .set(Configuration.APP_PACKAGE, "com.sample")
                .set(Configuration.APP_PROTOCOL, "http")
                .set(Configuration.APP_HOSTNAME, "localhost")
                .set(Configuration.APP_PORT, 8000)
                .set(Configuration.APP_KEYSTORE, "res/keystore.jks")
                .set(Configuration.APP_LANGUAGE, "en")
                .set(Configuration.DB_DRIVER, "mysql")
                .set(Configuration.DB_HOSTNAME, "localhost")
                .set(Configuration.DB_PORT, 3306)
                .set(Configuration.DB_NAME, "party")
                .set(Configuration.DB_USERNAME, "party")
                .set(Configuration.DB_PASSWORD, "party")
                .set(Configuration.DB_PARAMS, "?serverTimezone=UTC")
                .set(Configuration.CACHE_ENABLE, true)
                .set(Configuration.LOG_LEVEL, "ALL")
                .set(Configuration.LOG_CONSOLE, true)
                .set(Configuration.LOG_FILE, true)
        );
    }
}
