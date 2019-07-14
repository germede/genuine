package org.fluentness.flow.locale;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface LocaleConsumer<T extends LocaleProvider> extends Consumer {

    default T localizations() {
        return (T) Flow.call.localizations;
    }
}
