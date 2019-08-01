package org.fluentness.base.service.localization;

import org.fluentness.base.service.Service;

interface LocalizationService extends Service {


    boolean has(String key);

    String translate(String key);


    LocalizationService add(String translation, Language language);
}
