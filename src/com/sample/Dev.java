package com.sample;

import org.fluentness.FnBoot;
import org.fluentness.FnConf;

public class Dev {

    public static void main(String[] args) {

        FnConf configuration = new FnConf()
                .set(FnConf.APP_PACKAGE, "com.sample")
                .set(FnConf.APP_URL, "http://localhost:8000")
                .set(FnConf.APP_PORT, 8000)
                .set(FnConf.APP_DEFAULT_LANGUAGE, "en")
                .set(FnConf.DB_DRIVER, "mysql")
                .set(FnConf.DB_HOSTNAME, "localhost")
                .set(FnConf.DB_PORT, 3306)
                .set(FnConf.DB_NAME, "party")
                .set(FnConf.DB_USERNAME, "party")
                .set(FnConf.DB_PASSWORD, "party")
                .set(FnConf.DB_URL_PARAMS, "?serverTimezone=UTC")
                .set(FnConf.CACHE_ENABLE, true)
                ;

        FnBoot.initialize(args, configuration);
    }
}
