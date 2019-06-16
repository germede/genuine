package org.fluentness.model;

import org.fluentness.common.generics.Provider;
import org.fluentness.common.lambdas.KeyValuePair;

public abstract class ModelProvider implements Provider<Model>, PropertyFunctions {

    @Override
    public Class<Model> getProducedComponentType() {
        return Model.class;
    }

    protected Model properties(KeyValuePair<Property>... properties) {
        return new Model(properties);
    }
}
