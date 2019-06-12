package org.fluentness.form;

import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.localization.LocalizationFunctions;
import org.fluentness.view.MarkupElement;
import org.fluentness.view.MarkupFunctions;

public interface FormProvider extends Provider<Form>, HttpMethods, LocalizationFunctions, MarkupFunctions, FieldFunctions {

    default Form form(String method, String action, NamedValue<Field>... fields) {
        MarkupElement[] fieldMarkupElements = new MarkupElement[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldMarkupElements[i] = fields[i].value();
        }
        return new Form(method, action, fieldMarkupElements);
    }

}
