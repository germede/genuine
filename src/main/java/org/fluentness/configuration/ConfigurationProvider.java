package org.fluentness.configuration;

import org.fluentness.common.generics.Provider;
import org.fluentness.common.constants.Settings;

public abstract class ConfigurationProvider implements Provider<Configuration>, Settings {

    @Override
    public Class<Configuration> getProducedComponentType() {
        return Configuration.class;
    }

    protected Setting set(String key, Object value) {
        return new Setting(key,value);
    }

    protected Configuration settings(Setting... settings) {
        return new Configuration(settings);
    }
}
