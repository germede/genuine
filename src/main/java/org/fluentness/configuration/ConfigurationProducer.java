package org.fluentness.configuration;

import org.fluentness.base.constants.SettingKeys;
import org.fluentness.base.generics.Producer;

public abstract class ConfigurationProducer implements Producer<Configuration>, SettingKeys {

    @Override
    public Class<Configuration> getProducedComponentType() {
        return Configuration.class;
    }

    protected Configuration settings(Setting... settings) {
        return new Configuration(settings);
    }

    protected Setting set(String key, Object value) {
        return new Setting(key, value);
    }
}
