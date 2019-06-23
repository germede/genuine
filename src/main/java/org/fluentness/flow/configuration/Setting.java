package org.fluentness.flow.configuration;

import org.fluentness.common.constants.SettingKeys;

public class Setting {
    private SettingKeys.Key key;
    private String value;

    Setting(SettingKeys.Key key, String value) {
        this.key = key;
        this.value = value;
    }

    public SettingKeys.Key getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
