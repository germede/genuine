package org.fluentness.base.localization;

import org.fluentness.base.Service;

public interface Localization extends Service<Translations> {

    Translations getTranslations();

    default String translate(String key, Language language) {
        return getTranslations().translate(key, language);
    }
}