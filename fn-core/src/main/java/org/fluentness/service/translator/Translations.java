package org.fluentness.service.translator;

import java.util.HashMap;
import java.util.Map;

class Translations {

    private final Map<String, String> translations = new HashMap<>();

    Translations(String rawMessage) {
        String[] translations = rawMessage.split(AbstractStringTranslator.SEPARATOR);
        this.translations.put("default", translations[0]);
        for (int i = 1; i < translations.length; i++) {
            String[] translation = translations[i].split("#");
            this.translations.put(translation[0], translation[1]);
        }
    }

    String translate(String... languages) {
        for (String language : languages) {
            if (translations.containsKey(language)) {
                return translations.get(language);
            }
        }
        return translations.get("default");
    }
}
