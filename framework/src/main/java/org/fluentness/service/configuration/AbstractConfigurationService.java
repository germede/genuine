package org.fluentness.service.configuration;

public abstract class AbstractConfigurationService implements ConfigurationService {

    public String get(String key) {
        return getSettings().getSetting(key, getEnvironment());
    }

    public boolean is(String key) {
        return Boolean.parseBoolean(getSettings().getSetting(key, getEnvironment()));
    }

    public boolean has(String key) {
        return getSettings().getSetting(key, getEnvironment()).length() > 0;
    }
}