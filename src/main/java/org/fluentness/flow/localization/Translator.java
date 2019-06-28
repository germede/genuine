package org.fluentness.flow.localization;

import org.fluentness.base.constants.ViewPlaceholders;

public interface Translator {

    default String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

}
