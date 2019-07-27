package org.fluentness.flow.provider;

import org.fluentness.flow.component.form.Form;
import org.fluentness.flow.component.form.FormFactory;

public abstract class FormProvider extends Provider<Form> implements FormFactory {

    @Override
    public int getDefinitionPriority() {
        return 2200;
    }

    @Override
    public Class<Form> getComponentClass() {
        return Form.class;
    }

}
