package org.fluentness.service.translator;

import org.fluentness.service.Service;

public interface Translator extends Service {

    default String translate(String translation) {
        // todo implement
        return translation;
    }
}
