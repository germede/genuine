package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Translation implements CharSequence {

    private static final String DEFAULT = "default";

    private final Map<String, String> translations = new HashMap<>();

    Translation(String defaultTranslation, Map.Entry<String, String>[] translations) {
        this.translations.put(DEFAULT, defaultTranslation);
        for (Map.Entry<String, String> translation : translations) {
            this.translations.put(translation.getKey(), translation.getValue());
        }
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return translations.getOrDefault(Locale.getDefault().getLanguage(), translations.get(DEFAULT));
    }
}
