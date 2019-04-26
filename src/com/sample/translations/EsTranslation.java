package com.sample.translations;

import org.fluencyframework.lan.Translation;
import org.fluencyframework.lan.Translations;

public class EsTranslation implements Translation {



    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Bienvenido al sitio")
                .add("test_message", "Esto es un test");

    }

}
