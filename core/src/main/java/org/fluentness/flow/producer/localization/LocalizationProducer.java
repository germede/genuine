package org.fluentness.flow.producer.localization;

import org.fluentness.flow.producer.Producer;
import org.fluentness.base.common.lambda.KeyValuePair;

public abstract class LocalizationProducer extends Producer<Localization> {

    @Override
    public Class<Localization> getProducedComponentType() {
        return Localization.class;
    }

    protected Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
