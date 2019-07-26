package org.fluentness.flow.producer.localization;

import org.fluentness.flow.producer.view.ViewPlaceholders;

public interface Localizator {

    default String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

}
