package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private Map<Environment, String> settings = new HashMap<>();

    public String get(Environment environment) {
        return settings.getOrDefault(environment, "");
    }

    public Configuration dev(String value) {
        settings.put(Environment.DEV, value);
        return this;
    }

    public Configuration test(String value) {
        settings.put(Environment.TEST, value);
        return this;
    }

    public Configuration prod(String value) {
        settings.put(Environment.PROD, value);
        return this;
    }
}
