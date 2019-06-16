package org.fluentness.form;

import org.fluentness.Fluentness;
import org.fluentness.common.generics.Consumer;

public interface FormConsumer<T extends FormProvider> extends Consumer {

    default T forms() {
        return (T) Fluentness.INSTANCE.forms;
    }
}
