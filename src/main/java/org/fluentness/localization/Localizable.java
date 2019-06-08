package org.fluentness.localization;

import org.fluentness.FnAtoz;
import org.fluentness.common.networking.RequestRegister;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public interface Localizable {

    static Collection<Locale> getLocales() {
        return FnAtoz.getLocalizationProvider().provideAll().keySet()
            .stream().map(Locale::new).collect(Collectors.toList());
    }

    default String translate(String name) {
        LocalizationProvider localizationProvider = FnAtoz.getLocalizationProvider();
        Map<String, Localization> localizations = localizationProvider.provideAll();
        Localization localization = localizations.get(getLocale().getLanguage());
        if (localization != null) {
            return localization.get(name);
        } else {
            return name;
        }
    }

    default Locale getLocale() {
        return RequestRegister.getCurrent() != null ?
            RequestRegister.getCurrent().getPreferredLocale() :
            Locale.getDefault();
    }

}
