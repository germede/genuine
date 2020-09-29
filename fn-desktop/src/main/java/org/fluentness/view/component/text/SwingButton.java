package org.fluentness.view.component.text;

import org.fluentness.view.component.text.form.Button;
import org.fluentness.view.event.Handler;

import javax.swing.*;

public class SwingButton extends JButton implements Button {

    public SwingButton(CharSequence text) {
        super(text.toString());
    }

    @Override
    public void setText(CharSequence text) {
        setText(text.toString());
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void onClick(Handler handler) {

    }
}
