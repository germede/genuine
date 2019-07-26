package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.form.FormProducer;

public interface FormConsumer<T extends FormProducer> extends Consumer {

    default T forms() {
        return (T) Fluentness.getFlow().getProducer(FormProducer.class);
    }
}
