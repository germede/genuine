package org.fluentness.localization;

import org.fluentness.common.generics.Provider;
import org.fluentness.common.lambdas.KeyValuePair;

public abstract class LocalizationProvider implements Provider<Localization> {

    @Override
    public Class<Localization> getProducedComponentType() {
        return Localization.class;
    }

    protected Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
