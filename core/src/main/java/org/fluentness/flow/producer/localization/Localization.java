package org.fluentness.flow.producer.localization;

import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.flow.producer.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Localization extends Component {
    private Map<String, String> translations = new HashMap<>();

    Localization(KeyValuePair<String>... translations) {
        Arrays.stream(translations).forEach(translation -> this.translations.put(translation.getKey(), translation.getValue()));
    }

    public String get(String name) {
        return translations.getOrDefault(name, name);
    }

    public Map<String, String> getAll() {
        return translations;
    }
}
