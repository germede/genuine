package org.fluentness.flow.form;

import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.generics.Provider;
import org.fluentness.base.generics.KeyValuePair;
import org.fluentness.flow.locale.Localizator;
import org.fluentness.flow.view.HtmlFunctions;
import org.fluentness.flow.view.RawView;
import org.fluentness.flow.view.View;

public abstract class FormProvider extends Provider<Form> implements FieldFactory, Localizator, HttpMethods, HtmlFunctions {

    @Override
    public Class<Form> getProvidedComponentType() {
        return Form.class;
    }

    protected Form get(String action, KeyValuePair<Field>... fields) {
        return new Form(GET, action, fields);
    }

    protected Form post(String action, KeyValuePair<Field>... fields) {
        return new Form(POST, action, fields);
    }

    protected View raw(String raw) {
        return new RawView(raw);
    }
}
