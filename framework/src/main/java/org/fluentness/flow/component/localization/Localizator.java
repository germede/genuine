package org.fluentness.flow.component.localization;

import org.fluentness.flow.component.view.ViewPlaceholders;

public interface Localizator {

    default String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

}
