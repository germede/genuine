package org.fluentness.flow.locale;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface LocaleConsumer<T extends LocaleProvider> extends Consumer {

    default T locales() {
        return (T) Flow.instance.locales;
    }
}
