package org.fluentness.flow.form;

import org.fluentness.base.generics.Provider;
import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.flow.localization.Translator;
import org.fluentness.flow.view.HtmlFunctions;
import org.fluentness.flow.view.RawView;
import org.fluentness.flow.view.View;

public abstract class FormProvider implements Provider<Form>, Translator, HttpMethods, HtmlFunctions, FieldFunctions {

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

    protected View raw(String raw) {
        return new RawView(raw);
    }
}
