package org.fluentness.register;

import org.fluentness.localization.Localization;
import org.fluentness.logging.Logger;

import java.util.HashMap;
import java.util.Map;

public class LocalizationRegister {

    public static final String LOCALIZATION = "localization";

    private static Map<String, Localization.Translations> translations;
    static {
        translations = new HashMap<>();
        for (Class translationClass : ClassLoader.getExternalClasses(LOCALIZATION, Localization.class)) {
            try {
                Localization translationInstance = (Localization) translationClass.newInstance();
                translations.put(translationInstance.getLanguage().toLowerCase(), translationInstance.getTranslations());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }
    public static Localization.Translations getTranslation(String language) {
        return translations.get(language);
    }


}
