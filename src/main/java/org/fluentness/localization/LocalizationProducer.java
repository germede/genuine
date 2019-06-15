package org.fluentness.localization;

import org.fluentness.base.onion.Producer;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class LocalizationProducer implements Producer<Localization> {

    @Override
    public Class<Localization> getProducedComponentType() {
        return Localization.class;
    }

    protected Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
