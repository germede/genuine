package com.sample.localization;

import org.fluentness.localization.Localization;

import java.util.Locale;

public class EsLocalization implements Localization {

    @Override
    public Locale getLocale() {
        return new Locale("ES");
    }

    @Override
    public Translations getTranslations() {
        return translations(
                welcome_message -> "Bienvenido al sitio",
                test_message -> "Esto es un test"
        );
    }
}
