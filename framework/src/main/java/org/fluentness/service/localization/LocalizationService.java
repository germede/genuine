package org.fluentness.service.localization;

import org.fluentness.service.Service;

public interface LocalizationService extends Service {

    Language getDefaultLanguage();

    Language getCurrentLanguage();



    String translate(String key);
}