package com.sample;

import org.fluentness.Fluentness;

public class Dev {

    public static void main(String[] args) {
        Fluentness.initialize(args,
                app_package -> "com.sample",
                app_protocol -> "http",
                app_hostname -> "localhost",
                app_port -> 8000,
                app_keystore -> "res/keystore.jks",
                db_driver -> "mysql",
                db_hostname -> "localhost",
                db_port -> 3306,
                db_name -> "music",
                db_username -> "party",
                db_password -> "party",
                db_params -> "?serverTimezone=UTC",
                cache_enable -> false,
                log_level -> "ALL",
                log_console -> true,
                log_file -> true
        );
    }
}
