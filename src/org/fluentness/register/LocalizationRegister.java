package org.fluentness.register;

import org.fluentness.localization.Localization;
import org.fluentness.logging.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class LocalizationRegister {

    public static final String LOCALIZATION = "localization";

    private static final Map<Locale, Localization.Translations> translationsMap;
    static {
        translationsMap = new HashMap<>();
        for (Class translationClass : ClassLoader.getExternalClasses(LOCALIZATION, Localization.class)) {
            try {
                Localization translationInstance = (Localization) translationClass.newInstance();
                translationsMap.put(translationInstance.getLocale(), translationInstance.getTranslations());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }
    public static String getTranslation(Locale locale, String name) {
        return translationsMap.get(locale).get(name);
    }


    public static Collection<Locale> getLanguages() {
        return translationsMap.keySet();
    }
}
