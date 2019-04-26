package org.fluentness.translation;

public interface Translation {
    Translations getTranslations();

    default String getLanguage() {
        return this.getClass().getSimpleName().replace("Translation","").toLowerCase();
    }
}
