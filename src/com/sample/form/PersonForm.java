package com.sample.form;

import org.fluentness.form.Form;
import org.fluentness.form.TextField;

public class PersonForm implements Form {
    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Fields getFields() {
        return new Fields()
                .add(
                        new TextField("name").setRequired(true)

                );
    }
}
