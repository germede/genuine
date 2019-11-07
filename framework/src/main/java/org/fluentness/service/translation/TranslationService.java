package org.fluentness.service.translation;

import org.fluentness.service.Service;

public interface TranslationService extends Service {

    String translate(Translation key, String... parameters);
}