package com.sample.localization;

import org.fluentness.localization.Localization;
import org.fluentness.localization.Translations;

public class EnLocalization implements Localization {

    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Welcome to the site")
                .add("test_message", "This is a test message");

    }

}
