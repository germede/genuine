package org.fluentness.flow.provider;

import org.fluentness.flow.component.form.Form;
import org.fluentness.flow.component.form.FormFactory;

public abstract class FormProvider extends Provider<Form> implements FormFactory {

    @Override
    public Class<Form> getProducedComponentType() {
        return Form.class;
    }


}
