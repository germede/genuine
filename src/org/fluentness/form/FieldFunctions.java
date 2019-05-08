package org.fluentness.form;

public interface FieldFunctions {

    default TextField text() {
        return new TextField();
    }

    class TextField extends Field {
        private TextField() {
            super("text");
        }
    }
}
