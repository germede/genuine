package org.fluentness.flow.form;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface FormConsumer<T extends FormProvider> extends Consumer {

    default T forms() {
        return (T) Flow.instance.getProvider(FormProvider.class);
    }
}
