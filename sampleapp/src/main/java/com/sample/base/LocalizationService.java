package com.sample.base;

import org.fluentness.base.provider.localization.Language;

import java.util.HashMap;
import java.util.Map;

public class LocalizationService implements Service<Localization> {

    private Localization localization;
    private Map<Language, Map<String, String>> translations = new HashMap();

    public LocalizationService(Localization localization) {
        this.localization = localization;
        for (String string : localization.provideAll()) {
            if ()

            translations.put()
        }
    }





}
