package org.fluentness.localization;

import org.fluentness.Fluentness;
import org.fluentness.common.ClassRegister;

public interface Localizable {

    default String translate(String name) {
        return ClassRegister.getTranslations().get(getLanguage()).get(name);
    }

    default String getLanguage() {
        return Fluentness.Configuration.getString(Fluentness.Configuration.APP_LANGUAGE);
    }
}
