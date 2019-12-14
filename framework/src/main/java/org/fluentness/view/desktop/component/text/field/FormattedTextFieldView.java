package org.fluentness.view.desktop.component.text.field;

import javax.swing.*;

public class FormattedTextFieldView extends AbstractTextFieldView<FormattedTextFieldView, JFormattedTextField> {

    public FormattedTextFieldView() {
        super(new JFormattedTextField());
    }

    public FormattedTextFieldView focusLostBehavior(int behavior) {
        view.setFocusLostBehavior(behavior);
        return this;
    }

    public FormattedTextFieldView formatterFactory(JFormattedTextField.AbstractFormatterFactory tf) {
        view.setFormatterFactory(tf);
        return this;
    }

    public FormattedTextFieldView value(Object value) {
        view.setValue(value);
        return this;
    }
}
