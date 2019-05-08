package org.fluentness.model;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Model {

    default String getTable() {
        return this.getClass().getSimpleName().toLowerCase().replace("model", "");
    }

    default String getPrimaryKey() {
        getPrimary
    }

    Properties getProperties();

    class Properties {

        private Map<String, Property> properties = new HashMap<>();

        public Properties(NamedValue<Property>... properties) {
            Arrays.stream(properties).forEach(translation -> this.properties.put(translation.name(), translation.value()));
        }

        public Property get(String name) {
            return properties.get(name);
        }

        public boolean contains(String name) {
            return properties.containsKey(name);
        }
    }
}
