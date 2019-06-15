package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface TaskConsumer<T extends TaskProducer> extends Consumer {

    default T tasks() {
        return (T) Fluentness.INSTANCE.tasks;
    }
}
