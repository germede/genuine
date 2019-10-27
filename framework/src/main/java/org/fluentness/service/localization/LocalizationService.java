package org.fluentness.service.localization;

import org.fluentness.service.Service;

import java.lang.annotation.*;

public interface LocalizationService extends Service {

    Language getDefaultLanguage();

    Language getCurrentLanguage();

    String translate(String key);

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Translates.class)
    @interface Translate {
        Language to();
        String as();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Translates {
        Translate[] value();
    }
}