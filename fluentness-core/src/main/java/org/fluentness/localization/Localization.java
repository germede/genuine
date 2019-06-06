package org.fluentness.localization;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public interface Localization {
    Locale getLocale();

    Translations getTranslations();

    default Translations translations(NamedValue<String>... translations) {
        return new Translations(translations);
    }

    class Translations {

        private Map<String, String> translations = new HashMap<>();

        private Translations(NamedValue<String>... translations) {
            Arrays.stream(translations).forEach(translation -> this.translations.put(translation.name(), translation.value()));
        }

        public String get(String name) {
            return translations.getOrDefault(name, name);
        }
    }
}
