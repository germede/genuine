package com.sample.translations;

import org.fluentness.translation.Translation;
import org.fluentness.translation.Translations;

public class EnTranslation implements Translation {

    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Welcome to the site")
                .add("test_message", "This is a test message");

    }

}
