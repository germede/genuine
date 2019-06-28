package org.fluentness.flow.configuration;

import org.fluentness.base.constants.SettingKeys;
import org.fluentness.base.generics.Provider;

public abstract class ConfigurationProvider extends Provider<Configuration> implements SettingKeys {

    @Override
    public Class<Configuration> getProducedComponentType() {
        return Configuration.class;
    }

    protected Setting set(SettingKeys.Key key, String value) {
        return new Setting(key,value);
    }

    protected Configuration settings(Setting... settings) {
        return new Configuration(settings);
    }

}
