package org.fluentness.localization;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Localization {
    private Map<String, String> translations = new HashMap<>();

    public Localization(KeyValuePair<String>... translations) {
        Arrays.stream(translations).forEach(translation -> this.translations.put(translation.key(), translation.value()));
    }

    public String get(String name) {
        return translations.getOrDefault(name, name);
    }
}
