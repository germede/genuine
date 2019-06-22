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

    private Map<String, Object> parameters;
    private View template;

    View setTemplate(View view) {
        this.template = view;
        return this;
    }

    boolean hasParameters() {
        return parameters != null && !parameters.isEmpty();
    }

    public View assigning(KeyValuePair<Object>... parameters) {
        if (this.parameters != null) {
            this.parameters.clear();
        } else {
            this.parameters = new HashMap<>();
        }
        Arrays.stream(parameters).forEach(parameter -> this.parameters.put(parameter.getKey(), parameter.getValue()));
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
        return localize(
            parametrize(
                render()
            )
        );
    }

    public abstract String render();

    private String parametrize(String toParametrize) {
        if (hasParameters()) {
            Matcher matcher = Pattern.compile("\\{\\{P:([A-Za-z1-9_]+)}}").matcher(toParametrize);
            while (matcher.find()) {
                toParametrize = toParametrize.replace(matcher.group(0), String.valueOf(parameters.get(matcher.group(1))));
            }
        }
        return toParametrize;
    }

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
