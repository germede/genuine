package org.fluentness.service.localization;

public abstract class AbstractLocalizationService implements LocalizationService {

    protected abstract Translations getTranslations();

    public String translate(String key, Language language) {
        return getTranslations().translate(key, language);
    }
}