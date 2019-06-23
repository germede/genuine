package org.fluentness.flow.configuration;

import org.fluentness.common.constants.SettingKeys;
import org.fluentness.common.generics.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Configuration implements Component {
    
    private Map<SettingKeys.Key, String> settings = new HashMap<>();

    Configuration(Setting... settings) {
        Arrays.stream(settings).forEach(setting -> this.settings.put(setting.getKey(), setting.getValue()));
    }

    public boolean containsKey(SettingKeys.Key key) {
        return settings.containsKey(key);
    }

    public String get(SettingKeys.Key key) {
        return settings.get(key);
    }

}
