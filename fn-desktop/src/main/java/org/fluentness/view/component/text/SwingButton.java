package org.fluentness.view.component.text;

import org.fluentness.view.component.text.form.Button;

import javax.swing.*;

public class SwingButton extends JButton implements Button {

    public SwingButton(CharSequence text) {
        super(text.toString());
    }

    @Override
    public void setText(CharSequence text) {
        setText(text.toString());
    }

}
