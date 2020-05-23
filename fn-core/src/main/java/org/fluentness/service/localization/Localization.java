package org.fluentness.service.localization;

public interface Localization {

    default String localize(Translation translation) {
        return translation.toString();
    }

}
