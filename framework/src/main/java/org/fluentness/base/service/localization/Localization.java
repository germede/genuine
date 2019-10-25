package org.fluentness.base.service.localization;

import org.fluentness.base.service.Service;

public interface Localization extends Service {

    Translations getTranslations();

    default String translate(String key, Language language) {
        return getTranslations().translate(key, language);
    }
}