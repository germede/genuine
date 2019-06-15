package org.fluentness.localization;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface LocalizationConsumer<T extends LocalizationProducer> extends Consumer {

    default T localizations() {
        return (T) Fluentness.INSTANCE.localizations;
    }
}
