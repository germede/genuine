package org.fluentness.flow.form;

import org.fluentness.common.constants.ViewPlaceholders;
import org.fluentness.common.generics.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.common.lambdas.KeyValuePair;
import org.fluentness.flow.view.HtmlFunctions;
import org.fluentness.flow.view.RawView;
import org.fluentness.flow.view.View;

public abstract class FormProvider implements Provider<Form>, HttpMethods, HtmlFunctions, FieldFunctions {

    protected String translate(String name) {
        return String.format(ViewPlaceholders.LOCALIZATION_PLACEHOLDER, name);
    }

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
