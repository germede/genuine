package org.fluentness.flow.configuration;

import static org.fluentness.base.constants.SettingKeys.*;

public enum DefaultConfiguration {

    call;

    public Configuration get() {
        return new Configuration(
            new Setting(APP_PROTOCOL, "http"),
            new Setting(APP_HOST, "localhost"),
            new Setting(APP_PORT, "8000"),
            new Setting(HIBERNATE_DRIVER, "mysql"),
            new Setting(HIBERNATE_DRIVER_CLASS, "com.mysql.cj.jdbc.Driver"),
            new Setting(HIBERNATE_DIALECT, "org.hibernate.dialect.MySQLDialect"),
            new Setting(HIBERNATE_HOST, "localhost"),
            new Setting(HIBERNATE_PORT, "3306"),
            new Setting(LOG_LEVEL, "ALL"),
            new Setting(ENABLE_HIBERNATE, "false"),
            new Setting(ENABLE_LOG_TO_CONSOLE, "true"),
            new Setting(ENABLE_LOG_TO_FILE, "true"),
            new Setting(ENABLE_CACHE, "true"),
            new Setting(ENABLE_STYLE_MINIFY, "true")
        );
    }
}
