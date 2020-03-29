package org.fluentness.service.translator;

import org.fluentness.service.Service;

import static org.fluentness.service.translator.TranslationFactory.SEPARATOR;


public interface Translator extends Service {

    default String translate(String translation, String... sortedLanguages) {
        for (String language : sortedLanguages) {
            String search = SEPARATOR + language;
            if (translation.contains(search)) {
                int beginIndex = translation.indexOf(search) + search.length();
                int endIndex = translation.indexOf(SEPARATOR, beginIndex + 1);
                return translation.substring(beginIndex, endIndex);
            }
        }
        if (translation.contains(SEPARATOR)) {
            return translation.substring(0, translation.indexOf(SEPARATOR));
        }
        return translation;
    }


}
