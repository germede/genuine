package org.fluentness.model;

import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.common.components.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Model implements Component {

    private Map<String, Property> properties = new HashMap<>();

    Model(KeyValuePair<Property>... properties) {
        Arrays.stream(properties).forEach(property -> this.properties.put(property.getKey(), property.getValue()));
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
