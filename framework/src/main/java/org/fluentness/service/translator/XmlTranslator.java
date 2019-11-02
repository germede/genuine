package org.fluentness.service.translator;

import org.fluentness.service.configuration.Configuration;

import java.util.ResourceBundle;

public class XmlTranslator implements Translator {

    private String resourceBundleName;
    private XmlResourceBundleControl control;

    public XmlTranslator(Configuration configuration) {
        resourceBundleName = configuration.has("translator_bundle") ? configuration.get("translator_bundle") : "messages";
        control = new XmlResourceBundleControl();
    }

    @Override
    public String translate(String key, String... parameters) {
        return String.format(ResourceBundle.getBundle(resourceBundleName, control).getString(key), parameters);
    }

}