package org.fluentness.form;

import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.onion.Producer;
import org.fluentness.localization.LocalizationFunctions;
import org.fluentness.view.MarkupFunctions;

public abstract class FormProducer implements Producer<Form>, HttpMethods, LocalizationFunctions, MarkupFunctions, FieldFunctions {

    @Override
    public Class<Form> getProducedComponentType() {
        return Form.class;
    }

    protected Form get(String action, KeyValuePair<Field>... fields) {
        return new Form("get", action, fields);
    }

    protected Form post(String action, KeyValuePair<Field>... fields) {
        return new Form("post", action, fields);
    }

}
