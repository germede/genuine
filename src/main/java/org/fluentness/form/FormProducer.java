package org.fluentness.form;

import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.generics.Producer;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.localization.LocalizationFunctions;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.MarkupFunctions;

public abstract class FormProducer implements Producer<Form>, HttpMethods, LocalizationFunctions, MarkupFunctions, FieldFunctions {

    @Override
    public Class<Form> getProducedComponentType() {
        return Form.class;
    }

    protected Form get(String action, KeyValuePair<Field>... fields) {
        MarkupElement[] fieldMarkupElements = new MarkupElement[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldMarkupElements[i] = fields[i].value();
        }
        return new Form("get", action, fieldMarkupElements);
    }

    protected Form post(String action, KeyValuePair<Field>... fields) {
        MarkupElement[] fieldMarkupElements = new MarkupElement[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldMarkupElements[i] = fields[i].value();
        }
        return new Form("post", action, fieldMarkupElements);
    }

}
