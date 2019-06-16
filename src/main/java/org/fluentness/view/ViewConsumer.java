package org.fluentness.view;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface ViewConsumer<T extends ViewProvider> extends Consumer {

    default T views() {
        return (T) Fluentness.INSTANCE.views;
    }

}
