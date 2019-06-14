package org.fluentness.model;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private Map<String, Attribute> properties = new HashMap<>();

    Model(KeyValuePair<Attribute>... properties) {
        Arrays.stream(properties).forEach(translation -> this.properties.put(translation.key(), translation.value()));
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
