package org.fluentness.model;

import org.fluentness.base.onion.Producer;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class ModelProducer implements Producer<Model>, PropertyFunctions {

    @Override
    public Class<Model> getProducedComponentType() {
        return Model.class;
    }

    protected Model properties(KeyValuePair<Property>... properties) {
        return new Model(properties);
    }
}
