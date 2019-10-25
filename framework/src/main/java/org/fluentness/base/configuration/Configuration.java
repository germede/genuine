package org.fluentness.base.configuration;

import org.fluentness.base.Service;

public interface Configuration extends Service<Settings> {

    Settings getSettings();

    Environment getEnvironment();

    default String get(String key) {
        return getSettings().getSetting(key, getEnvironment());
    }

    default boolean is(String key) {
        return Boolean.parseBoolean(getSettings().getSetting(key, getEnvironment()));
    }

    default boolean has(String key) {
        return getSettings().getSetting(key, getEnvironment()).length() > 0;
    }
}