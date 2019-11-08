package org.fluentness.controller.desktop.swing.component.text.field;

import javax.swing.*;

public class PasswordFieldView extends AbstractTextFieldView<PasswordFieldView,JPasswordField> {

    private JPasswordField jPasswordField = new JPasswordField();

    @Override
    public JPasswordField getSwingView() {
        return jPasswordField;
    }

    public PasswordFieldView echoChar(char c) {
        jPasswordField.setEchoChar(c);
        return this;
    }
}
