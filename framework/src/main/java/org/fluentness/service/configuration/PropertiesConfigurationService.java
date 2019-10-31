package org.fluentness.service.configuration;

import java.util.ResourceBundle;

public class PropertiesConfigurationService implements ConfigurationService {

    @Override
    public String get(String key) {
        return ResourceBundle.getBundle("configuration" + getEnvironment()).getString(key);
    }

    @Override
    public boolean is(String key) {
        return Boolean.parseBoolean(get(key));
    }

    @Override
    public boolean has(String key) {
        return ResourceBundle.getBundle("configuration" + getEnvironment()).containsKey(key);
    }

    private Environment getEnvironment() {
        return Environment.valueOf(System.getProperty("environment"));
    }

}