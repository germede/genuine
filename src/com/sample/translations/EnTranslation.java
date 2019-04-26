package com.sample.translations;

import org.fluentworkflow.loc.Translation;
import org.fluentworkflow.loc.Translations;

public class EnTranslation implements Translation {

    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Welcome to the site")
                .add("test_message", "This is a test message");

    }

}
