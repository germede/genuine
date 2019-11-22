package org.fluentness.service.translator;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Translation {

    private String defaultTranslation;
    private Map<String, String> map;

    Translation(String defaultTranslation, Message[] map) {
        this.defaultTranslation = defaultTranslation;
        this.map = Arrays.stream(map).collect(
            Collectors.toMap(translationn -> translationn.getLanguage().name(), Message::getMessage)
        );
    }

    public String translate() {
        return map.getOrDefault(Locale.getDefault().getLanguage(), defaultTranslation);
    }
}
