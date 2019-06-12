package org.fluentness.localization;

import org.fluentness.common.lambdas.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Localization {
    private Map<String, String> translations = new HashMap<>();

    public Localization(NamedValue<String>... translations) {
        Arrays.stream(translations).forEach(translation -> this.translations.put(translation.name(), translation.value()));
    }

    public String get(String name) {
        return translations.getOrDefault(name, name);
    }
}
