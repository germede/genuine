package org.fluentness.service.translator;

import java.util.Locale;
import java.util.ResourceBundle;

public class XmlTranslator implements Translator {

    private Locale currentLocale;
    private XmlResourceBundleControl control;

    public XmlTranslator() {
        control = new XmlResourceBundleControl();
    }

    @Override
    public String translate(String key, String... parameters) {
        return String.format(ResourceBundle.getBundle("localization", control).getString(key), parameters);
    }

}