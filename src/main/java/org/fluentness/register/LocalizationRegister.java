package org.fluentness.register;

import org.fluentness.common.PackageNames;
import org.fluentness.localization.Localization;
import org.fluentness.logger.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class LocalizationRegister {

    private static final Map<Locale, Localization.Translations> translationsMap;
    static {
        translationsMap = new HashMap<>();
        for (Class translationClass : ClassLoader.getExternalClasses(PackageNames.LOCALIZATION, Localization.class)) {
            try {
                Localization localization = (Localization) translationClass.newInstance();
                ClassInjector.injectFields(localization);
                translationsMap.put(localization.getLocale(), localization.getTranslations());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }
    public static String getTranslation(Locale locale, String name) {
        return translationsMap.get(locale).get(name);
    }

    public static Collection<Locale> getLocales() {
        return translationsMap.keySet();
    }
}
