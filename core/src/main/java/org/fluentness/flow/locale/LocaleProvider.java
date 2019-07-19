package org.fluentness.flow.locale;

import org.fluentness.base.generics.Provider;
import org.fluentness.base.lambdas.KeyValuePair;

public abstract class LocaleProvider extends Provider<Locale> {

    @Override
    public Class<Locale> getProducedComponentType() {
        return Locale.class;
    }

    protected Locale translations(KeyValuePair<String>... translations) {
        return new Locale(translations);
    }

}
