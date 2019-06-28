package org.fluentness.base;

import org.fluentness.base.constants.SettingKeys;
import org.fluentness.flow.configuration.Configuration;
import org.fluentness.flow.configuration.DefaultConfiguration;

public enum Settings {

    call;

    private Configuration appliedConfiguration;
    private Configuration defaultConfiguration = DefaultConfiguration.call.get();

    public void apply(Configuration configuration) {
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
