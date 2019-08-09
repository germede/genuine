package org.fluentness.base.service.configuration;

import org.fluentness.base.service.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.configuration.FluentnessSettings.*;

public interface ConfigurationService extends Service {

    class DefaultSettings {
        private static final Map<Setting, String> settings = new HashMap<>();

        static {
            // default settings
            settings.put(appProtocol, "http");
            settings.put(appHost, "localhost");
            settings.put(appPort, "8000");
            settings.put(logLevel, "INFO");
            settings.put(logToConsole, "true");
            settings.put(compressStyles, "true");
        }

        private DefaultSettings() {

        }
    }

    default String get(String key) {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.getName().equals(key) && field.getType().isAssignableFrom(String.class))
                .map(field -> {
                    try {
                        return (String)field.get(this);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .findFirst()
                .orElse(DefaultSettings.settings.getOrDefault(key,""));
    }

}