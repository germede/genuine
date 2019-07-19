package org.fluentness.flow.locale;

import org.fluentness.base.constants.ViewPlaceholders;

public interface Localizator {

    default String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

}
