package org.fluentness.flow.view.form;

import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.view.RawView;
import org.fluentness.flow.view.View;

import static org.fluentness.base.service.server.HttpMethod.GET;
import static org.fluentness.base.service.server.HttpMethod.POST;

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
