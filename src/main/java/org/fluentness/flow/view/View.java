package org.fluentness.flow.view;

import org.fluentness.common.generics.Component;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.flow.localization.Localizable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class View implements Component, Localizable {

    private Map<String, Object> parameters;

    public View assigning(KeyValuePair<Object>... parameters) {
        this.parameters = new HashMap<>();
        Arrays.stream(parameters).forEach(parameter -> this.parameters.put(parameter.getKey(), parameter.getValue()));
        return this;
    }

    @Override
    public String toString() {
        // for caching
        return localize(render());
    }

    public abstract String render();

    abstract View setTemplate(View view);
}
