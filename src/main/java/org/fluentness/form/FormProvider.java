package org.fluentness.form;

import org.fluentness.common.components.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.localization.Localizable;
import org.fluentness.view.HtmlFunctions;
import org.fluentness.view.RawView;
import org.fluentness.view.View;

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
