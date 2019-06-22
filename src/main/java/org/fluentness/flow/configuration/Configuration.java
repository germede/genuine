package org.fluentness.flow.configuration;

import org.fluentness.common.generics.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Configuration implements Component {
    
    private Map<String, Object> settings = new HashMap<>();

    Configuration(Setting[] settings) {
        Arrays.stream(settings).forEach(setting -> this.settings.put(setting.getKey(), setting.getValue()));
    }

    public boolean containsValue(Object value) {
        return settings.containsKey(value);
    }

    public boolean containsKey(String key) {
        return settings.containsKey(key);
    }

    public Object get(String key) {
        return settings.get(key);
    }

}
