package org.fluentness.flow.locale;

import org.fluentness.base.generics.Provider;
import org.fluentness.base.generics.KeyValuePair;

public abstract class LocaleProvider extends Provider<Locale> {

    @Override
    public Class<Locale> getProvidedComponentType() {
        return Locale.class;
    }

    protected Locale translations(KeyValuePair<String>... translations) {
        return new Locale(translations);
    }

}
