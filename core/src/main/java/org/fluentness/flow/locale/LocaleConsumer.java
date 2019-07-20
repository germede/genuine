package org.fluentness.flow.locale;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface LocaleConsumer<T extends LocaleProvider> extends Consumer {

    default T locales() {
        return (T) Fluentness.flow.getProvider(LocaleProvider.class);
    }
}
