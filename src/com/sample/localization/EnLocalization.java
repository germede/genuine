package com.sample.localization;

import org.fluentness.localization.Localization;

public class EnLocalization implements Localization {

    @Override
    public String getLanguage() {
        return "EN";
    }

    @Override
    public Translations getTranslations() {
        return new Translations()
                .add("welcome_message", "Welcome to the site")
                .add("test_message", "This is a test message");

    }

}
