package org.fluentness.service.localization;

public abstract class AbstractLocalization implements Localization {

    protected static Translation msg(String defaultTranslation) {
        return new Translation(defaultTranslation);
    }

}