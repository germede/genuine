package org.fluentness;

import org.fluentness.common.constants.SettingKeys;
import org.fluentness.flow.configuration.Configuration;
import org.fluentness.flow.configuration.DefaultConfiguration;

public enum Settings {

    INSTANCE;

    private Configuration appliedConfiguration;
    private Configuration defaultConfiguration = DefaultConfiguration.INSTANCE.get();

    void apply(Configuration configuration) {
        this.appliedConfiguration = configuration;
    }

    public String get(SettingKeys.Key key) {
        if (appliedConfiguration.containsKey(key)) {
            return appliedConfiguration.get(key);
        } else if (defaultConfiguration.containsKey(key)){
            return defaultConfiguration.get(key);
        } else {
            return "";
        }
    }

    public boolean is(SettingKeys.Key key) {
        if (appliedConfiguration.containsKey(key)) {
            return Boolean.parseBoolean(appliedConfiguration.get(key));
        } else if (defaultConfiguration.containsKey(key)){
            return Boolean.parseBoolean(defaultConfiguration.get(key));
        } else {
            return true;
        }
    }
}
