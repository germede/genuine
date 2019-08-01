package org.fluentness.base.service.localization;

import org.fluentness.base.service.configuration.ConfigurationService;
import org.fluentness.base.service.logger.FluentnessLogLevel;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLocalizationService implements LocalizationService {

    private Map<String, Map<Language, String>> translations = new HashMap<>();

    @Override
    public <T> boolean has(String key) {
        return translations.containsKey(key);
    }

    @Override
    public String translate(String key) {
        return (T) translations.get(key);
    }



    @Override
    public LocalizationService add(Language language, String key, String translation) {
        if (translations.containsKey(language)) {
            translations.put(language, new HashMap<>());
        }
        translations.get(language).put(key, value);
        return this;
    }

    public abstract void configure();
}