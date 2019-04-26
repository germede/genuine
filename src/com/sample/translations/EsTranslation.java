package com.sample.translations;

import org.fluentworkflow.lan.Translation;
import org.fluentworkflow.lan.Translations;

public class EsTranslation implements Translation {



    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Bienvenido al sitio")
                .add("test_message", "Esto es un test");

    }

}
