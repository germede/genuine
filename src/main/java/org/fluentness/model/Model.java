package org.fluentness.model;

import org.fluentness.common.NamedValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public interface Model extends ColumnFunctions {

    default String getTable() {
        return this.getClass().getSimpleName().toLowerCase().replace("model", "");
    }

    Columns getColumns();

    default String getPrimaryKey() {
        return "id";
    }

    default Columns columns(NamedValue<Column>... properties) {
        return new Columns(properties);
    }

    class Columns {

        private Map<String, Column> properties = new HashMap<>();

        private Columns(NamedValue<Column>... properties) {
            Arrays.stream(properties).forEach(translation -> this.properties.put(translation.name(), translation.value()));
        }

        public Column get(String name) {
            return properties.get(name);
        }

        public boolean contains(String name) {
            return properties.containsKey(name);
        }
    }
}
