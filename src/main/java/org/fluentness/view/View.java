package org.fluentness.view;

import org.fluentness.FnAtoz;
import org.fluentness.localization.Localization;
import org.fluentness.localization.LocalizationFunctions;
import org.fluentness.localization.LocalizationProvider;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View implements LocalizationFunctions {

    public String render() {

        ViewProvider viewProvider = FnAtoz.getViewProvider();
        String viewName = viewProvider.getNameFor(this);

        if (viewProvider.isAnnotationPresent(viewName, ViewProvider.Template.class)) {
            View template = viewProvider.get(
                ((ViewProvider.Template) viewProvider.getAnnotation(viewName, ViewProvider.Template.class)).value()
            );
            return localize(template.toString().replace(ViewProvider.placeholder, toString()));
        }
        return localize(toString());
    }

    private String localize(String toLocalize) {
        Map<String, Localization> all = FnAtoz.getLocalizationProvider().getAll();
        Localization localization = FnAtoz.getLocalizationProvider().get(getLocale().toString());
        if (localization == null) {
            localization = FnAtoz.getLocalizationProvider().get(getLocale().getLanguage());
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
