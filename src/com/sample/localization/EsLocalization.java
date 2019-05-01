package com.sample.localization;

import org.fluentness.localization.Localization;

public class EsLocalization implements Localization {

    @Override
    public String getLanguage() {
        return "ES";
    }

    @Override
    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Bienvenido al sitio")
                .add("test_message", "Esto es un test");

    }

}
