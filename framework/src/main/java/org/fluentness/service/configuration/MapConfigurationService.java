package org.fluentness.service.configuration;

import java.util.HashMap;
import java.util.Map;

public abstract class MapConfigurationService implements ConfigurationService {

    private Map<String, Configuration> configurationMap = new HashMap<>();

    public MapConfigurationService() {
        configure();
    }

    @Override
    public String get(String key) {
        return configurationMap.get(key).get(getCurrentEnvironment());
    }

    @Override
    public boolean is(String key) {
        return Boolean.parseBoolean(get(key));
    }

    @Override
    public boolean has(String key) {
        return configurationMap.containsKey(key);
    }

    protected Configuration add(String key) {
        Configuration configuration = new Configuration();
        configurationMap.put(key, configuration);
        return configuration;
    }

    protected abstract void configure();
}