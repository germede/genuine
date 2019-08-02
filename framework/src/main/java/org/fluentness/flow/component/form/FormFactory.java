package org.fluentness.flow.component.form;

import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.component.view.RawView;
import org.fluentness.flow.component.view.View;

import static org.fluentness.base.common.constant.HttpMethod.GET;
import static org.fluentness.base.common.constant.HttpMethod.POST;

public final class FormFactory {

    private FormFactory() {

    }

    public static Form get(String action, KeyValuePairLambda<Field>... fields) {
        return new Form(GET, action, fields);
    }

    public static Form post(String action, KeyValuePairLambda<Field>... fields) {
        return new Form(POST, action, fields);
    }

    public static View raw(String string) {
        return new RawView(string);
    }
}
