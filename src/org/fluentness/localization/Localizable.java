package org.fluentness.localization;

import org.fluentness.register.LocalizationRegister;
import org.fluentness.register.RequestRegister;

public interface Localizable {

    default String translate(String name) {
        return LocalizationRegister.getTranslation(
                RequestRegister.getCurrent().getPreferredLocale(),
                name);
    }
}
