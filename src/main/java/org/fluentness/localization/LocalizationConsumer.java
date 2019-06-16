package org.fluentness.localization;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface LocalizationConsumer<T extends LocalizationProvider> extends Consumer {

    default T localizations() {
        return (T) Fluentness.INSTANCE.localizations;
    }
}
