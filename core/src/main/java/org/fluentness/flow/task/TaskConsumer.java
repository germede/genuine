package org.fluentness.flow.task;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface TaskConsumer<T extends TaskProvider> extends Consumer {

    default T tasks() {
        return (T) Flow.instance.getProvider(TaskProvider.class);
    }
}
