package org.fluentness.localization;

public interface Localizable {

    default String translate(String key) {
        return "LLL:" + key + "#";
    }
}
