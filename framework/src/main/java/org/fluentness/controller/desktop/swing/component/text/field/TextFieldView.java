package org.fluentness.controller.desktop.swing.component.text.field;

import javax.swing.*;

public class TextFieldView extends AbstractTextFieldView<TextFieldView,JTextField> {

    private JTextField jTextField = new JTextField();

    @Override
    public JTextField getSwingView() {
        return jTextField;
    }
}
