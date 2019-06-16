package org.fluentness.style;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface StyleConsumer<T extends StyleProvider> extends Consumer {

    default T styles() {
        return (T) Fluentness.INSTANCE.styles;
    }
}
