package org.fluentness.localization;

import org.fluentness.ClassRegister;

public interface Localizable {

    default String translate(String key, String language) {
        Translations translations = ClassRegister.getTranslations().get(language);
        if (translations != null && translations.contains(key)) {
            return translations.get(key);
        }
        return key;
    }
}
