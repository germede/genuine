package org.fluentness.service.translator;

import org.fluentness.service.Service;

public interface TranslatorService extends Service {

    String translate(String key, String... parameters);

}