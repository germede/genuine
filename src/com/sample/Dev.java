package com.sample;

import org.fluentness.Fluentness;

public class Dev {

    public static void main(String[] args) {

        Fluentness.initialize(args,
                APP_PACKAGE -> "com.sample",
                APP_PROTOCOL -> "http",
                APP_HOSTNAME -> "localhost",
                APP_PORT -> 8000,
                APP_KEYSTORE -> "res/keystore.jks",
                APP_LANGUAGE -> "en",
                DB_DRIVER -> "mysql",
                DB_HOSTNAME -> "localhost",
                DB_PORT -> 3306,
                DB_NAME -> "party",
                DB_USERNAME -> "party",
                DB_PASSWORD -> "party",
                DB_PARAMS -> "?serverTimezone=UTC",
                CACHE_ENABLE -> false,
                LOG_LEVEL -> "ALL",
                LOG_CONSOLE -> true,
                LOG_FILE -> true
        );
    }
}
