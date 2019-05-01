package org.fluentness.localization;

import java.util.HashMap;
import java.util.Map;

public interface Localization {
    String getLanguage();

    Translations getTranslations();

    class Translations {

        private Map<String, String> translations = new HashMap<>();

        public Translations add(String key, String translation) {
            translations.put(key, translation);
            return this;
        }

        public String get(String key) {
            return translations.getOrDefault(key,"");
        }

        public boolean contains(String key) {
            return translations.containsKey(key);
        }
    }
}
