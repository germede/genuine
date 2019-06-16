package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.common.generics.Consumer;

public interface TaskConsumer<T extends TaskProvider> extends Consumer {

    default T tasks() {
        return (T) Fluentness.INSTANCE.tasks;
    }
}
