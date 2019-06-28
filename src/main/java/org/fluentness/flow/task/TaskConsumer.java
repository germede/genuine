package org.fluentness.flow.task;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface TaskConsumer<T extends TaskProvider> extends Consumer {

    default T tasks() {
        return (T) Fluentness.INSTANCE.tasks;
    }
}
