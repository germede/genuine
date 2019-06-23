package org.fluentness.flow.view;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.ViewPlaceholders;
import org.fluentness.common.generics.Component;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.common.networking.HttpRequestRegister;
import org.fluentness.flow.localization.Localization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class View implements Component {

    private static final Map<Thread, Map<String, Object>> parameters = new HashMap<>();
    boolean hasParameters() {
        return parameters.get(Thread.currentThread()) != null && !parameters.get(Thread.currentThread()).isEmpty();
    }

    protected static Object retrieveParameterForCurrentThread(String parameter) {
        return parameters.get(Thread.currentThread()).get(parameter);
    }

    private View template;

    View setTemplate(View view) {
        this.template = view;
        return this;
    }

    public View assigning(KeyValuePair<Object>... parameters) {
        if (View.parameters.containsKey(Thread.currentThread())) {
            View.parameters.get(Thread.currentThread()).clear();
        } else {
            View.parameters.put(Thread.currentThread(),new HashMap<>());
        }
        Arrays.stream(parameters).forEach(
            parameter -> View.parameters.get(Thread.currentThread()).put(parameter.getKey(), parameter.getValue())
        );
        return this;
    }

    public String renderWithCache() {
        String rendered = ViewCache.INSTANCE.cache(this);
        if (template != null) {
            rendered = ViewCache.INSTANCE.cache(template).replace(ViewPlaceholders.TEMPLATE_PLACEHOLDER, rendered);
        }
        return rendered;
    }

    @Override
    public String toString() {
        return localize(render());
    }

    public abstract String render();

    private String localize(String toLocalize) {
        Map<String, Localization> all = Fluentness.INSTANCE.localizations.getAll();
        Localization localization = Fluentness.INSTANCE.localizations.get(HttpRequestRegister.getCurrentLocale().toString());
        if (localization == null) {
            localization = Fluentness.INSTANCE.localizations.get(HttpRequestRegister.getCurrentLocale().getLanguage());
        }
        if (localization == null) {
            localization = new Localization();
        }
        localization.get("cancel");

        Matcher matcher = Pattern.compile("\\{\\{L:([A-Za-z1-9_]+)}}").matcher(toLocalize);
        while (matcher.find()) {
            toLocalize = toLocalize.replace(matcher.group(0), localization.get(matcher.group(1)));
        }
        return toLocalize;
    }
}
