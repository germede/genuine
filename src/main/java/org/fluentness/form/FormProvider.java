package org.fluentness.form;

import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.localization.Localizable;
import org.fluentness.view.HtmlFunctions;

public interface FormProvider extends Provider<Form>, HttpMethods, Localizable, HtmlFunctions, FieldFunctions {

    default Form form(String method, String action, NamedValue<Field>... fields) {
        return new Form(method, action, fields);
    }

}
