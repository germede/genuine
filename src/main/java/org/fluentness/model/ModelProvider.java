package org.fluentness.model;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.generics.Provider;

public interface ModelProvider extends Provider<Model>, AttributeFunctions {

    default Model properties(KeyValuePair<Attribute>... properties) {
        return new Model(properties);
    }
}
