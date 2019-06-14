package org.fluentness.configuration;

import org.fluentness.base.constants.Settings;
import org.fluentness.base.generics.Provider;

public interface ConfigurationProvider extends Provider<Configuration>, Settings {

    default Configuration settings(Setting... settings) {
        return new Configuration(settings);
    }

    default Setting set(String key, Object value) {
        return new Setting(key, value);
    }
}
