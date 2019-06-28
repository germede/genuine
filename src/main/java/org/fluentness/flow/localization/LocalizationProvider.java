package org.fluentness.flow.localization;

import org.fluentness.base.generics.Provider;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class LocalizationProvider extends Provider<Localization> {

    @Override
    public Class<Localization> getProducedComponentType() {
        return Localization.class;
    }

    protected Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
