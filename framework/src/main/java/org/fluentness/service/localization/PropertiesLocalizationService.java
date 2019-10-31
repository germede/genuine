package org.fluentness.service.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesLocalizationService implements LocalizationService {

    private Locale currentLocale;

    @Override
    public String translate(String key) {
        return ResourceBundle.getBundle("localization", currentLocale).getString(key);
    }

    @Override
    public void setCurrentLocale(Locale locale) {
        this.currentLocale = locale;
    }

}