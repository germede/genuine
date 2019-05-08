package com.sample.form;

import org.fluentness.form.Form;

public class PersonForm implements Form {
    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Fields getFields() {
        return new Fields(
                name -> text().required()
        );
    }
}
