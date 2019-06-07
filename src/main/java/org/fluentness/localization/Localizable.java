package org.fluentness.localization;

import org.fluentness.configuration.Configuration;
import org.fluentness.register.RequestRegister;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public interface Localizable {

    default String translate(String name) {
        LocalizationProvider localizationProvider = getLocalizationProvider();
        Map<Locale, LocalizationProvider.Localization> localizations = localizationProvider.getLocalizations();
        LocalizationProvider.Localization localization = localizations.get(getLocale());

        if (localization != null) {
            return localization.get(name);
        } else {
            return "asdf";
        }
    }

    static Collection<Locale> getLocales() {
        return getLocalizationProvider().getLocalizations().keySet();
    }

    default Locale getLocale() {
        return RequestRegister.getCurrent().getPreferredLocale();
    }

    static LocalizationProvider getLocalizationProvider() {
        try {
            String s = Configuration.getString(Configuration.APP_PACKAGE) + ".Localizations";
            LocalizationProvider localizationProvider = (LocalizationProvider) Class.forName(s).newInstance();
            return localizationProvider;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new LocalizationProvider() {
        };
    }
}
