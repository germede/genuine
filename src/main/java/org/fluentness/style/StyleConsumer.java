package org.fluentness.style;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface StyleConsumer<T extends StyleProducer> extends Consumer {

    default T styles() {
        return (T) Fluentness.INSTANCE.styles;
    }
}
