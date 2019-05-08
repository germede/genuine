package org.fluentness.localization;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Localization {
    String getLanguage();

    Translations getTranslations();

    class Translations {

        private Map<String, String> translations = new HashMap<>();

        public Translations(NamedValue<String>... translations) {
            Arrays.stream(translations).forEach(translation -> this.translations.put(translation.name(), translation.value()));
        }

        public String get(String name) {
            return translations.getOrDefault(name, name);
        }

        public boolean contains(String name) {
            return translations.containsKey(name);
        }
    }
}
