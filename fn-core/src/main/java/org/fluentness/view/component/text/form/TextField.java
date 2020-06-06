package org.fluentness.view.component.text.form;

public interface TextField {

    enum Type {
        TEXT,
        PASSWORD,
        URL,
        EMAIL,
        PHONE,
        NUMBER,
        DISABLED,
    }

    Type getType();

}
