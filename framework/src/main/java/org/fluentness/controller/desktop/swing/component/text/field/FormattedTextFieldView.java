package org.fluentness.controller.desktop.swing.component.text.field;

import javax.swing.*;

public class FormattedTextFieldView extends AbstractTextFieldView<FormattedTextFieldView, JFormattedTextField> {

    private JFormattedTextField jFormattedTextField = new JFormattedTextField();

    @Override
    public JFormattedTextField getSwingView() {
        return jFormattedTextField;
    }

    public FormattedTextFieldView focusLostBehavior(int behavior) {
        jFormattedTextField.setFocusLostBehavior(behavior);
        return this;
    }

    public FormattedTextFieldView formatterFactory(JFormattedTextField.AbstractFormatterFactory tf) {
        jFormattedTextField.setFormatterFactory(tf);
        return this;
    }

    public FormattedTextFieldView value(Object value) {
        jFormattedTextField.setValue(value);
        return this;
    }
}
