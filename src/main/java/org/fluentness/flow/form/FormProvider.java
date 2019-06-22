package org.fluentness.flow.form;

import org.fluentness.common.generics.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.flow.localization.Localizable;
import org.fluentness.flow.view.HtmlFunctions;
import org.fluentness.flow.view.RawView;
import org.fluentness.flow.view.View;

public abstract class FormProvider implements Provider<Form>, Localizable, HttpMethods, HtmlFunctions, FieldFunctions {

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
