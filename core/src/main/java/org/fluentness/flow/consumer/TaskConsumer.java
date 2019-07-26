package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.task.TaskProducer;

public interface TaskConsumer<T extends TaskProducer> extends Consumer {

    default T tasks() {
        return (T) Fluentness.getFlow().getProducer(TaskProducer.class);
    }
}
