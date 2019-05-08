package org.fluentness.localization;

import org.fluentness.Fluentness;
import org.fluentness.register.ClassRegister;

public interface Localizable {

    default String translate(String name) {
        return ClassRegister.getTranslation(getLanguage()).get(name);
    }

    default String getLanguage() {
        return Fluentness.Configuration.getString(Fluentness.Configuration.APP_LANGUAGE);
    }
}
