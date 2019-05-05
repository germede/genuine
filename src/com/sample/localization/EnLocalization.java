package com.sample.localization;

import org.fluentness.localization.Localization;

public class EnLocalization implements Localization {

    @Override
    public String getLanguage() {
        return "EN";
    }

    @Override
    public Translations getTranslations() {
        return new Translations(
                welcome_message -> "Welcome to the site",
                test_message -> "This is a test message"
        );
    }

}
