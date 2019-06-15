package org.fluentness.model;

import org.fluentness.base.generics.Producer;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class ModelProducer implements Producer<Model>, AttributeFunctions {

    @Override
    public Class<Model> getProducedComponentType() {
        return Model.class;
    }

    protected Model properties(KeyValuePair<Attribute>... properties) {
        return new Model(properties);
    }
}
