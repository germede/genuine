package org.fluentness.model;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Model implements Component {

    private Map<String, Property> properties = new HashMap<>();

    Model(KeyValuePair<Property>... properties) {
        Arrays.stream(properties).forEach(property -> this.properties.put(property.key(), property.value()));
    }

    public String getTable() {
        return this.getClass().getSimpleName().toLowerCase().replace("model", "");
    }

    public String getPrimaryKey() {
        return "id";
    }

    public Property get(String name) {
        return properties.get(name);
    }

}
