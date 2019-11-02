package org.fluentness.service.configuration;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class XmlConfiguration implements Configuration {


    private final Properties properties;

    public XmlConfiguration() throws IOException {
        properties = new Properties();
        properties.loadFromXML(
            Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("configuration" + getEnvironment() + ".xml"))
        );
    }

    @Override
    public String get(String key) {
        return properties.getProperty(key);
    }

    @Override
    public boolean is(String key) {
        return Boolean.parseBoolean(get(key));
    }

    @Override
    public boolean has(String key) {
        return properties.containsKey(key);
    }

    @Override
    public Environment getEnvironment() {
        String environment = System.getProperty("environment");
        return environment == null || environment.isEmpty() ?
            Environment.DEV :
            Environment.valueOf(environment.toUpperCase());
    }

}