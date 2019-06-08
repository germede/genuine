package org.fluentness.model;

import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.Provider;

public interface ModelProvider extends Provider<Model>, AttributeFunctions {

    default Model properties(NamedValue<Attribute>... properties) {
        return new Model(properties);
    }
}
