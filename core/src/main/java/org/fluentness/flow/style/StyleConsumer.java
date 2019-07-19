package org.fluentness.flow.style;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface StyleConsumer<T extends StyleProvider> extends Consumer {

    default T styles() {
        return (T) Flow.instance.getProvider(StyleProvider.class);
    }
}
