package org.fluentness.service.translator;

import org.fluentness.service.Service;

import java.util.Locale;

public interface Translator extends Service {

    char DELIMITER = '\007';

    static String translate(String message) {
        String language = Locale.getDefault().getLanguage();
        String contains = DELIMITER + language + DELIMITER;
        if (message.contains(contains)) {
            int beginIndex = message.indexOf(contains) + contains.length();
            int endIndex = message.indexOf(DELIMITER, beginIndex);
            return message.substring(beginIndex, endIndex);
        } else if (message.indexOf(DELIMITER) > -1) {
            return message.substring(0, message.indexOf(DELIMITER));
        }
        return message;
    }

}
