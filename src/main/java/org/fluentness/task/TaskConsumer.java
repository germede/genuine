package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface TaskConsumer<T extends TaskProvider> extends Consumer {

    default T tasks() {
        return (T) Fluentness.INSTANCE.tasks;
    }
}
