package org.fluentness.view;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Register;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.localization.Localization;
import org.fluentness.localization.LocalizationFunctions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.fluentness.base.components.Components.localizations;
import static org.fluentness.base.components.Components.views;
import static org.fluentness.base.constants.Settings.VIEW_CACHE;


public abstract class View implements Serializable, LocalizationFunctions, Register<String, Object> {

    abstract String render();

    public String toString() {

        // retrieving cache
        if (Fluentness.getBoolean(VIEW_CACHE) && ViewCache.INSTANCE.isCacheable(this)) {
            return ViewCache.INSTANCE.retrieve(this);
        }

        // initialization
        String rendered;
        ViewProvider viewProvider = views();
        String viewName = viewProvider.getNameFor(this);

        // templating
        if (viewProvider.isAnnotationPresent(viewName, ViewProvider.Template.class)) {
            View template = viewProvider.get(
                ((ViewProvider.Template) viewProvider.getAnnotation(viewName, ViewProvider.Template.class)).value()
            );
            rendered = template.render().replace(ViewProvider.placeholder, render());
        } else {
            rendered = render();
        }

        // localization
        Map<String, Localization> all = localizations().getAll();
        Localization localization = localizations().get(getLocale().toString());
        if (localization == null) {
            localization = localizations().get(getLocale().getLanguage());
        }
        if (localization == null) {
            localization = new Localization();
        }
        localization.get("cancel");

        Matcher matcher = Pattern.compile("\\{\\{([A-Za-z1-9_]+)}}").matcher(rendered);
        while (matcher.find()) {
            rendered = rendered.replace(matcher.group(0), localization.get(matcher.group(1)));
        }

        // storing cache
        if (Fluentness.getBoolean(VIEW_CACHE)) {
            ViewCache.INSTANCE.store(this,rendered);
        }

        return rendered;
    }

    public View with(KeyValuePair<Object>... parameters) {
        Arrays.stream(parameters).forEach(objectNamedValue -> put(objectNamedValue.key(), objectNamedValue.value()));
        return this;
    }

}
