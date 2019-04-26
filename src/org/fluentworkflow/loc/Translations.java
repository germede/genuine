package org.fluentworkflow.loc;

import java.util.HashMap;
import java.util.Map;

public class Translations {

    private Map<String, String> translations = new HashMap<>();

    public Translations add(String key, String translation) {
        translations.put(key, translation);
        return this;
    }

    public String get(String key) {
        return translations.get(key);
    }

    public boolean contains(String key) {
        return translations.containsKey(key);
    }
}
