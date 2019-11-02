package org.fluentness.service.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class XmlLocalizationService implements LocalizationService {

    private Locale currentLocale;
    private XmlResourceBundleControl control;

    public XmlLocalizationService() {
        control = new XmlResourceBundleControl();
    }

    @Override
    public String translate(String key, String... parameters) {
        return String.format(ResourceBundle.getBundle("localization", control).getString(key), parameters);
    }

}