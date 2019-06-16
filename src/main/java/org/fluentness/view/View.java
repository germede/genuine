package org.fluentness.view;

import org.fluentness.common.caching.Cacheable;
import org.fluentness.common.components.Component;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.configuration.Configuration;
import org.fluentness.localization.Localizable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.common.constants.Settings.VIEW_CACHE;

public abstract class View implements Component, Cacheable, Localizable {

    public static final String LOCALIZATION_PLACEHOLDER = "{{%s}}";
    static final String TEMPLATE_PLACEHOLDER = "###TEMPLATE_PLACEHOLDER###";

    private Map<String, Object> parameters;

    public View assigning(KeyValuePair<Object>... parameters) {
        this.parameters = new HashMap<>();
        Arrays.stream(parameters).forEach(parameter -> this.parameters.put(parameter.getKey(), parameter.getValue()));
        return this;
    }

    @Override
    public String cache() {

        if (Configuration.INSTANCE.getBoolean(VIEW_CACHE) && ViewCache.INSTANCE.doesCacheFileExists(this)) {
            return ViewCache.INSTANCE.retrieve(this);
        }

        String rendered = localize(render());

        if (Configuration.INSTANCE.getBoolean(VIEW_CACHE)) {
            ViewCache.INSTANCE.store(this, rendered);
        }

        return rendered;
    }

    public abstract String render();

    View setTemplate(View view) {
        // overridable
        return this;
    }
}
