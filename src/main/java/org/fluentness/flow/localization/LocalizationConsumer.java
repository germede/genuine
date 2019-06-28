package org.fluentness.flow.localization;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface LocalizationConsumer<T extends LocalizationProvider> extends Consumer {

    default T localizations() {
        return (T) Flow.call.localizations;
    }
}
