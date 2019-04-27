package com.sample.localization;

import org.fluentness.localization.Localization;
import org.fluentness.localization.Translations;

public class EsLocalization implements Localization {


    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Bienvenido al sitio")
                .add("test_message", "Esto es un test");

    }

}
