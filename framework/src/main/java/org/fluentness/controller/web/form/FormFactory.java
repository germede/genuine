package org.fluentness.controller.web.form;

import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.text.RawView;

public final class FormFactory {

    private FormFactory() {

    }

//    public static Form get(String action, KeyValuePairLambda<Field>... fields) {
//        return new Form(GET, action, fields);
//    }
//
//    public static Form post(String action, KeyValuePairLambda<Field>... fields) {
//        return new Form(POST, action, fields);
//    }

    public static WebView raw(String string) {
        return new RawView(string);
    }
}
