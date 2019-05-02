package com.sample;

import org.fluentness.FnBoot;
import org.fluentness.FnConf;

import static org.fluentness.FnConf.*;

public class Dev {

    public static void main(String[] args) {

        FnConf configuration = new FnConf()
                .set(APP_PACKAGE, "com.sample")
                .set(APP_URL, "http://localhost:8000")
                .set(APP_PORT, 8000)
                .set(APP_DEFAULT_LANGUAGE, "en")
                .set(DB_DRIVER, "mysql")
                .set(DB_HOSTNAME, "localhost")
                .set(DB_PORT, 3306)
                .set(DB_NAME, "party")
                .set(DB_USERNAME, "party")
                .set(DB_PASSWORD, "party")
                .set(DB_URL_PARAMS, "?serverTimezone=UTC")
                .set(CACHE_ENABLE, true);

        FnBoot.initialize(args, configuration);
    }
}
