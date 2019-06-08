package com.sample;

import org.fluentness.FnBoot;

public class Atoz {

    static final Controllers controllers = new Controllers();
    static final Forms forms = new Forms();
    static final Localizations localizations = new Localizations();
    static final Models models = new Models();
    static final Styles styles = new Styles();
    static final Tasks tasks = new Tasks();
    static final Views views = new Views();

    public static void main(String[] args) {
        FnBoot.initialize(args,
            app_protocol -> "http",
            app_hostname -> "localhost",
            app_port -> 8000,
            app_keystore -> "res/keystore.jks",
            provider_controllers -> controllers,
            provider_forms -> forms,
            provider_localizations -> localizations,
            provider_models -> models,
            provider_styles -> styles,
            provider_tasks -> tasks,
            provider_views -> views,
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
