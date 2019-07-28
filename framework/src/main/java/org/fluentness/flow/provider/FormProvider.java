package org.fluentness.flow.provider;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.flow.component.form.Form;
import org.fluentness.flow.component.form.FormFactory;

@DefinitionPriority(2200)
public abstract class FormProvider extends Provider<Form> implements FormFactory {

    @Override
    public final Class<Form> getComponentClass() {
        return Form.class;
    }

}
