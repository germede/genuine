package org.fluentness.localization;

import org.fluentness.register.LocalizationRegister;
import org.fluentness.register.RequestRegister;

import java.util.Locale;

public interface Localizable {

    default String translate(String name) {
        return LocalizationRegister.getTranslation(
                getLocale(),
                name);
    }

    default Locale getLocale() {
        return RequestRegister.getCurrent().getPreferredLocale();
    }
}
