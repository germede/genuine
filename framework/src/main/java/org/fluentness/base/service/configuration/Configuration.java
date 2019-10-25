package org.fluentness.base.service.configuration;

import org.fluentness.base.service.Service;

public interface Configuration extends Service {

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