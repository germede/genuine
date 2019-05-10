package org.fluentness.localization;

import org.fluentness.Fluentness;
import org.fluentness.register.LocalizationRegister;

public interface Localizable {

    default String translate(String name) {
        return LocalizationRegister.getTranslation(getLanguage()).get(name);
    }

    default String getLanguage() {
        return Fluentness.Configuration.getString(Fluentness.Configuration.APP_LANGUAGE);
    }
}
