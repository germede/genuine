package org.fluentness.flow.producer.form;

import org.fluentness.base.common.constant.HttpMethods;
import org.fluentness.flow.producer.Producer;
import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.flow.producer.localization.Localizator;
import org.fluentness.flow.producer.view.HtmlFunctions;
import org.fluentness.flow.producer.view.RawView;
import org.fluentness.flow.producer.view.View;

public abstract class FormProducer
    extends Producer<Form>
    implements FieldFactory, Localizator, HttpMethods, HtmlFunctions {

    @Override
    public Class<Form> getProducedComponentType() {
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
