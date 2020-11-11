package org.fluentness.service.translator;

import org.fluentness.service.Service;

import java.util.Locale;

public interface Translator extends Service {

    String translate(String message, String language);

    default String translate(String message) {
        return translate(message, Locale.getDefault().getLanguage());
    }

}
