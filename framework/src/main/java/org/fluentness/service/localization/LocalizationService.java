package org.fluentness.service.localization;

import org.fluentness.service.Service;

import java.util.Locale;

public interface LocalizationService extends Service {

    String translate(String key);

    void setCurrentLocale(Locale locale);

}