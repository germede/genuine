package com.sample.localization;

import org.fluentness.localization.Localization;

import java.util.Locale;


public class EnLocalization implements Localization {

    @Override
    public Locale getLocale() {
        return Locale.getDefault();
    }

    @Override
    public Translations getTranslations() {
        return translations(
                welcome_message -> "Welcome to the site",
                test_message -> "This is a test message"
        );
    }

}
