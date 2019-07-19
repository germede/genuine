package org.fluentness.flow.view;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface ViewConsumer<T extends ViewProvider> extends Consumer {

    default T views() {
        return (T) Flow.instance.views;
    }

}
