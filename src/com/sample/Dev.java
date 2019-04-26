package com.sample;

import org.fluentworkflow.Fwf;
import org.fluentworkflow.Configuration;

public class Dev {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
        .set(Configuration.APP_PACKAGE, "com.sample")
        .set(Configuration.APP_PORT, "8000")
        .set(Configuration.DB_DRIVER, "mysql")
        .set(Configuration.DB_HOSTNAME, "localhost")
        .set(Configuration.DB_PORT, "3306")
        .set(Configuration.DB_NAME, "party")
        .set(Configuration.DB_USERNAME, "party")
        .set(Configuration.DB_PASSWORD, "party")
        .set(Configuration.DB_URLPARAMS, "?serverTimezone=UTC");

        Fwf.initialize(args, configuration);
    }
}
