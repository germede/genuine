package org.fluentness.service.translation;

import java.util.Locale;

public abstract class AbstractTranslationService implements TranslationService {

    @Override
    public final String translate(Translation key, String... parameters) {
        return String.format(key.get(Locale.getDefault()), parameters);
    }

    protected static Translation msg(String defaultTranslation) {
        return new Translation(defaultTranslation);
    }

}