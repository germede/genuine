package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Map;

public abstract class MapLocalizationService implements LocalizationService {

    private Map<String, Localization> localizationMap = new HashMap<>();

    public MapLocalizationService() {
        configure();
    }

    @Override
    public String translate(String key) {
        return localizationMap.get(key).get(getCurrentLanguage());
    }

    protected Localization add(String key) {
        Localization localization = new Localization();
        localizationMap.put(key, localization);
        return localization;
    }

    protected abstract void configure();
}