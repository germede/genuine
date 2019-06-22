package org.fluentness.flow.localization;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.ViewPlaceholders;
import org.fluentness.common.networking.HttpRequest;
import org.fluentness.common.networking.HttpRequestRegister;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Localizable {

    static Locale getCurrentLocale() {
        HttpRequest httpRequest = HttpRequestRegister.INSTANCE.getCurrent();
        return httpRequest != null ?
            httpRequest.getPreferredLocale() :
            Locale.getDefault();
    }

    default String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER,name);
    }

    default String localize(String toLocalize) {
        Map<String, Localization> all = Fluentness.INSTANCE.localizations.getAll();
        Localization localization = Fluentness.INSTANCE.localizations.get(getCurrentLocale().toString());
        if (localization == null) {
            localization = Fluentness.INSTANCE.localizations.get(getCurrentLocale().getLanguage());
        }
        if (localization == null) {
            localization = new Localization();
        }
        localization.get("cancel");

        Matcher matcher = Pattern.compile("\\{\\{([A-Za-z1-9_]+)}}").matcher(toLocalize);
        while (matcher.find()) {
            toLocalize = toLocalize.replace(matcher.group(0), localization.get(matcher.group(1)));
        }
        return toLocalize;
    }

}
