package org.fluentness.flow.locale;

import org.fluentness.base.generics.KeyValuePair;
import org.fluentness.base.generics.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Locale extends Component {
    private Map<String, String> translations = new HashMap<>();

    Locale(KeyValuePair<String>... translations) {
        Arrays.stream(translations).forEach(translation -> this.translations.put(translation.getKey(), translation.getValue()));
    }

    public String get(String name) {
        return translations.getOrDefault(name, name);
    }
}
