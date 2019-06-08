package org.fluentness.model;

import org.fluentness.common.lambdas.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private Map<String, Attribute> properties = new HashMap<>();

    Model(NamedValue<Attribute>... properties) {
        Arrays.stream(properties).forEach(translation -> this.properties.put(translation.name(), translation.value()));
    }

    public String getTable() {
        return this.getClass().getSimpleName().toLowerCase().replace("model", "");
    }

    public String getPrimaryKey() {
        return "id";
    }

    public Attribute get(String name) {
        return properties.get(name);
    }

}
