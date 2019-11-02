package org.fluentness.service.translator;

import org.fluentness.service.configuration.ConfigurationService;

import java.util.ResourceBundle;

public class XmlTranslatorService implements TranslatorService {

    private String resourceBundleName;
    private XmlResourceBundleControl control;

    public XmlTranslatorService(ConfigurationService configuration) {
        resourceBundleName = configuration.has("translator_bundle") ? configuration.get("translator_bundle") : "messages";
        control = new XmlResourceBundleControl();
    }

    @Override
    public String translate(String key, String... parameters) {
        return String.format(ResourceBundle.getBundle(resourceBundleName, control).getString(key), parameters);
    }

}