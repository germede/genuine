package org.fluentness.localization;

public interface Localization {
    Translations getTranslations();

    default String getLanguage() {
        return this.getClass().getAnnotation(Language.class).value();
    }
}
