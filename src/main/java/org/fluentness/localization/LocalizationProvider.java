package org.fluentness.localization;

import org.fluentness.common.NamedValue;

import java.lang.reflect.Field;
import java.util.*;

public interface LocalizationProvider extends Singleton {

    default Map<Locale, Localization> getLocalizations() {

        Map<Locale, Localization> result = new HashMap<>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (Localization.class.equals(field.getType())) {

                    Localization localization = (Localization) field.get(this);
                    result.put(new Locale(field.getName()), localization);

                }
                field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    default Localization translations(NamedValue<String>... translations) {
        return new Localization(translations);
    }

    class Localization {
        private Map<String, String> translations = new HashMap<>();

        private Localization(NamedValue<String>... translations) {
            Arrays.stream(translations).forEach(translation -> this.translations.put(translation.name(), translation.value()));
        }

        public String get(String name) {
            return translations.getOrDefault(name, name);
        }
    }
}
