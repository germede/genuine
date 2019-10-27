package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLocalizationService implements LocalizationService {

    private Map<String, Localization> localizationMap = new HashMap<>();

    public AbstractLocalizationService() {
        configure();
    }

    @Override
    public String translate(String key) {
        if (!localizationMap.containsKey(key)) return key;
        return localizationMap.get(key).get(getCurrentLanguage());
    }

    protected Localization add(String key) {
        Localization localization = new Localization();
        localizationMap.put(key, localization);
        return localization;
    }

    protected abstract void configure();
}