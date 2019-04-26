package com.sample.translations;

import org.fluentness.translation.Translation;
import org.fluentness.translation.Translations;

public class EsTranslation implements Translation {



    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Bienvenido al sitio")
                .add("test_message", "Esto es un test");

    }

}
